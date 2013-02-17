package org.spoutcraft.launcher.technic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.spoutcraft.launcher.technic.rest.RestAPI;
import org.spoutcraft.launcher.technic.rest.pack.CustomModpack;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomInfo extends PackInfo {
	@JsonProperty("name")
	private String displayName;
	@JsonProperty("user")
	private String user;
	@JsonProperty("friendly_name")
	private String name;
	@JsonProperty("version")
	private String version;
	@JsonProperty("url")
	private String url;
	@JsonProperty("logo")
	private String logoUrl;
	@JsonProperty("background")
	private String backgroundUrl;
	@JsonProperty("mirror")
	private boolean hasMirror;
	@JsonProperty("mirror_url")
	private String mirrorUrl;
	@JsonProperty("minecraft")
	private String minecraftVersion;
	@JsonProperty("logo_md5")
	private String logoMD5;
	@JsonProperty("background_md5")
	private String backgroundMD5;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String getRecommended() {
		return version;
	}

	@Override
	public String getLatest() {
		return version;
	}

	@Override
	public List<String> getBuilds() {
		List<String> builds = new ArrayList<String>(1);
		builds.add(getLatest());
		return builds;
	}

	@Override
	public boolean isLoading() {
		return false;
	}

	@Override
	public String getLogoURL() {
		return logoUrl;
	}

	@Override
	public String getBackgroundURL() {
		return backgroundUrl;
	}

	@Override
	public String getIconURL() {
		return logoUrl;
	}

	@Override
	public String getLogoMD5() {
		return logoMD5;
	}

	@Override
	public String getBackgroundMD5() {
		return backgroundMD5;
	}

	@Override
	public String getIconMD5() {
		return logoMD5;
	}

	@Override
	public CustomModpack getModpack() {
		return new CustomModpack(this);
	}

	public String getVersion() {
		return version;
	}

	public String getMinecraftVersion() {
		return minecraftVersion;
	}

	public String getUser() {
		return user;
	}

	public String getURL() {
		return url;
	}

	public boolean hasMirror() {
		return hasMirror;
	}

	public String getMirrorURL() {
		return mirrorUrl;
	}

	public PackInfo getPack() {
		try {
			if (this.hasMirror()) {
				RestAPI rest = new RestAPI(getMirrorURL());
				RestInfo restInfo = rest.getModpackInfo(getName());
				return restInfo;
			} else {
				return this;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
