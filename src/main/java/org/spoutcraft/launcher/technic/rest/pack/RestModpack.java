package org.spoutcraft.launcher.technic.rest.pack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.spoutcraft.launcher.exceptions.RestfulAPIException;
import org.spoutcraft.launcher.technic.RestInfo;
import org.spoutcraft.launcher.technic.rest.Mod;
import org.spoutcraft.launcher.technic.rest.Modpack;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestModpack extends Modpack {

	@JsonProperty("libraries")
	private String libraries;
	@JsonProperty("minecraft")
	private String minecraftVersion;
	@JsonProperty("forge")
	private String forgeVersion;
	@JsonProperty("mods")
	private Map<String, String> mods;

	private String name;
	private String displayName;
	private String build;

	private RestInfo info;

	public RestModpack setInfo(RestInfo info, String build) {
		this.info = info;
		this.name = info.getName();
		this.displayName = info.getDisplayName();
		this.build = build;
		return this;
	}

	public RestInfo getInfo() {
		return info;
	}

	@Override
	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String getBuild() {
		return build;
	}

	@Override
	public String getMinecraftVersion() {
		return minecraftVersion;
	}

	public String getForgeVersion() {
		return forgeVersion;
	}

	@Override
	public List<Mod> getMods() {
		List<Mod> modList = new ArrayList<Mod>(mods.size());
		for (String name : mods.keySet()) {
			modList.add(new Mod(name, mods.get(name), getRest()));
		}
		return modList;
	}

	@Override
	public String toString() {
		return "{ Modpack [name: " + name + ", build: " + build + ", libraries: " + libraries + ", minecraft: " + minecraftVersion + ", forge: " + forgeVersion + ", mods: " + mods + "] }";
	}

	public String getMD5() throws RestfulAPIException {
		return getRest().getModpackMD5(this.getName());
	}

}
