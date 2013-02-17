package org.spoutcraft.launcher.yml;

import java.io.File;
import org.spoutcraft.launcher.util.Utils;

public enum Resources implements YAMLResource {
	Special ("http://get.spout.org/special.yml",
			new File(Utils.getLauncherDirectory(), "spoutcraft" + File.separator + "config" + File.separator + "special.yml"),
			null),

	VIP ("http://get.spout.org/vip.yml",
			new File(Utils.getLauncherDirectory(), "spoutcraft" + File.separator + "config" + File.separator + "vip.yml"),
			null),

	Assets ("http://get.spout.org/assets.yml",
			new File(Utils.getLauncherDirectory(), "spoutcraft" + File.separator + "config" + File.separator + "assets.yml"),
			null),
	;

	final BaseYAMLResource resource;
	private Resources(String url, File directory, ResourceAction action) {
		this.resource = new BaseYAMLResource(url, directory, action);
	}

	@Override
	public YAMLProcessor getYAML() {
		return resource.getYAML();
	}

	@Override
	public boolean updateYAML() {
		return resource.updateYAML();
	}
}