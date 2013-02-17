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
