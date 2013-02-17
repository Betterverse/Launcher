package org.spoutcraft.launcher.technic.rest;

import org.spoutcraft.launcher.exceptions.RestfulAPIException;

public class Mod {
	private final String name;
	private final String version;
	private final String url;

	private RestAPI rest = null;

	public Mod(String name, String version, String downloadUrl) {
		this.name = name;
		this.version = version;
		this.url = downloadUrl;
	}

	public Mod(String name, String version, RestAPI rest) {
		this(name, version, rest.getModDownloadURL(name, version));
		this.rest = rest;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public String getURL() {
		return url;
	}

	public String getMD5() {
		if (rest != null) {
			try {
				return rest.getModMD5(name, version);
			} catch (RestfulAPIException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "{ Mod [name: " + name + ", version: " + version + "] }";
	}
}
