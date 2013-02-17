package org.spoutcraft.launcher.technic;

import java.util.logging.Level;

import org.spoutcraft.launcher.Settings;
import org.spoutcraft.launcher.api.Launcher;
import org.spoutcraft.launcher.exceptions.RestfulAPIException;
import org.spoutcraft.launcher.technic.rest.RestAPI;
import org.spoutcraft.launcher.technic.skin.ModpackSelector;
import org.spoutcraft.launcher.util.Utils;

public class PackManager {
	public static void initPacks(ModpackSelector selector) {
		PackMap packs = selector.getPackMap();
		for (String pack : Settings.getInstalledPacks()) {
			initPack(packs, pack);
		}

		if (packs.size() < 1) {
			for (String pack : RestAPI.getDefaults()) {
				initPack(packs, pack);
			}
		}
	}

	public static void initPack(PackMap packs, String pack) {
		OfflineInfo info = new OfflineInfo(pack);
		packs.put(pack, info);
	}

	public static PackInfo loadPack(PackMap packs, String pack) {
		RestAPI rest = RestAPI.getDefault();
		boolean custom = Settings.isPackCustom(pack);

		PackInfo loaded = packs.get(pack);
		if (loaded != null && !loaded.isLoading()) {
			return loaded;
		}

		try {
			if (custom) {
				CustomInfo info = RestAPI.getCustomModpack(RestAPI.getCustomPackURL(pack));
				if (!info.hasMirror()) {
					packs.add(info);
					return info;
				}

				rest = new RestAPI(info.getMirrorURL());
			}

			RestInfo info = rest.getModpackInfo(pack);
			return info;

		} catch (RestfulAPIException e) {
			if (Utils.getStartupParameters().isDebugMode()) {
				Launcher.getLogger().log(Level.SEVERE, "Unable to load modpack " + pack + " from Technic Rest API", e);
			} else {
				Launcher.getLogger().log(Level.SEVERE, "Unable to load modpack " + pack + " from Technic Rest API");
			}
			PackInfo info = packs.get(pack);
			if (info instanceof OfflineInfo) {
				((OfflineInfo) info).setLoading(false);
			}
			return info;
		}
		
	}

	public static void addRestPacks(ModpackSelector selector) {
		PackMap packs = selector.getPackMap();
		int index = 0;

		for (String pack : RestAPI.getDefaults()) {
			PackInfo info = loadPack(packs, pack);
			packs.add(info);
			packs.reorder(index, pack);
			index++;
			selector.selectPack(packs.getSelected());
		}
	}

	public static void addCustomPacks(ModpackSelector selector) {
		PackMap packs = selector.getPackMap();
		for (String pack : Settings.getInstalledPacks()) {
			if (Settings.isPackCustom(pack)) {
				PackInfo info = loadPack(packs, pack);
				packs.add(info);
				selector.selectPack(packs.getSelected());
			}
		}
	}

}
