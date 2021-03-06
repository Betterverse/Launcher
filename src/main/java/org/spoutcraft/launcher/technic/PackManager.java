/*
 * This file is part of Betterverse Launcher.
 *
 * Copyright (c) 2013, Betterverse <http://www.betterverse.net//>
 * Betterverse Launcher is licensed under the Spout License Version 1.
 *
 * Betterverse Launcher is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * Betterverse Launcher is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
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
			for (String pack : RestAPI.getDefaults().keySet()) {
				packs.put(pack, loadPack(packs, pack));
			}
		}
	}

	public static void initPack(PackMap packs, String pack) {
		OfflineInfo info = new OfflineInfo(pack);
		packs.put(pack, info);
	}

	public static PackInfo loadPack(PackMap packs, String pack) {
		PackInfo loaded = packs.get(pack);
		if (loaded != null && !loaded.isLoading()) {
			return loaded;
		}

		try {
			CustomInfo info = RestAPI.getCustomModpack(RestAPI.getDefaults().get(pack));
			return info;

		} catch (RestfulAPIException e) {
			if (Utils.getStartupParameters().isDebugMode()) {
				Launcher.getLogger().log(Level.SEVERE, "Unable to load modpack " + pack + " from Rest API", e);
			} else {
				Launcher.getLogger().log(Level.SEVERE, "Unable to load modpack " + pack + " from Rest API");
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

		for (String pack : RestAPI.getDefaults().keySet()) {
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
