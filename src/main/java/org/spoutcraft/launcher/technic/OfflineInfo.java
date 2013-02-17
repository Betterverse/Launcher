package org.spoutcraft.launcher.technic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.spoutcraft.launcher.Settings;
import org.spoutcraft.launcher.technic.rest.Modpack;
import org.spoutcraft.launcher.technic.rest.pack.OfflineModpack;

public class OfflineInfo extends PackInfo {
	private final String name;
	private final String version;
	private boolean loading = true;
	
	public OfflineInfo(String name) {
		this.name = name;
		this.version = Settings.getModpackBuild(name);
		init();
	}

	@Override
	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	@Override
	public String getDisplayName() {
		return name;
	}

	@Override
	public String getRecommended() {
		return version;
	}

	public void setLoading(boolean loading) {
		this.loading = loading;
	}

	@Override
	public boolean isLoading() {
		return loading;
	}

	@Override
	public String getLatest() {
		return version;
	}

	@Override
	public List<String> getBuilds() {
		List<String> builds = new ArrayList<String>(1);
		builds.add(version);
		return builds;
	}

	@Override
	public Modpack getModpack() {
		File installed = new File(this.getBinDir(), "installed");
		if (installed.exists()) {
			return new OfflineModpack(getName(), getBuild());
		}

		return null;
	}
}
