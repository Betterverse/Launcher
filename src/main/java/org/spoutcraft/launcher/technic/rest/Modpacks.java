package org.spoutcraft.launcher.technic.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.spoutcraft.launcher.exceptions.RestfulAPIException;
import org.spoutcraft.launcher.technic.RestInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Modpacks extends RestObject {

	@JsonProperty("modpacks")
	private Map<String, String> modpacks;
	@JsonProperty("mirror_url")
	private String mirrorURL;

	public String getDisplayName(String modpack) {
		return modpacks.get(modpack);
	}

	public List<RestInfo> getModpacks() throws RestfulAPIException {
		List<RestInfo> modpackInfos = new ArrayList<RestInfo>(modpacks.size());
		for (String pack : modpacks.keySet()) {
			RestInfo info = getRest().getModpackInfo(pack);
			modpackInfos.add(info);
		}
		return modpackInfos;
	}

	public String getMirrorURL() {
		return mirrorURL;
	}

	@Override
	public String toString() {
		return "{ Modpacks [modpacks: " + modpacks + "] }";
	}

	public Map<String, String> getMap() {
		return modpacks;
	}
}
