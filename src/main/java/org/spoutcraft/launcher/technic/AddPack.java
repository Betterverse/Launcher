package org.spoutcraft.launcher.technic;

import java.awt.Image;
import java.util.Collections;
import java.util.List;

import org.spoutcraft.launcher.skin.MetroLoginFrame;
import org.spoutcraft.launcher.technic.rest.pack.RestModpack;

public class AddPack extends PackInfo {
	private final static Image icon = MetroLoginFrame.getIcon("icon.png", 32, 32).getImage();
	private final static Image logo = MetroLoginFrame.getIcon("addNewPack.png", 180, 110).getImage();
	private final static Image background = MetroLoginFrame.getIcon("background.jpg", 880, 520).getImage().getScaledInstance(880, 520, Image.SCALE_SMOOTH);

	@Override
	public String getName() {
		return "addpack";
	}

	@Override
	public String getDisplayName() {
		return "Add Pack";
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
	public String getRecommended() {
		return "";
	}

	@Override
	public String getLatest() {
		return "";
	}

	@Override
	public boolean isLoading() {
		return false;
	}

	@Override
	public List<String> getBuilds() {
		return Collections.emptyList();
	}

	@Override
	public RestModpack getModpack() {
		return null;
	}
}
