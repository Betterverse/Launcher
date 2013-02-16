package org.spoutcraft.launcher.technic;

import java.awt.Image;

import org.spoutcraft.launcher.skin.MetroLoginFrame;

public class BetterverseInfo extends CustomInfo {
	private final Image icon;
	private final Image logo;
	private final Image background;
	private final String name;
	private final String displayName;

	public BetterverseInfo(String name, String displayName, String icon, String logo, String background) {
		this.icon = MetroLoginFrame.getIcon(icon, 32, 32).getImage();
		this.logo = MetroLoginFrame.getIcon(logo, 180, 110).getImage();
		this.background = MetroLoginFrame.getIcon(background, 880, 520).getImage().getScaledInstance(880, 520, Image.SCALE_SMOOTH);
		this.name = name;
		this.displayName = displayName;
	}

	@Override
	public Image getBackground() {
		return background;
	}

	@Override
	public Image getLogo() {
		return logo;
	}

	@Override
	public Image getIcon() {
		return icon;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public boolean hasMirror() {
		return true;
	}

	@Override
	public String getMirrorURL() {
		return "http://www.sctgaming.com/Technic/API/";
	}
}
