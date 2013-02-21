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
package org.spoutcraft.launcher.technic.skin;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JTextArea;

import org.spoutcraft.launcher.skin.MetroLoginFrame;
import org.spoutcraft.launcher.skin.components.LiteButton;
import org.spoutcraft.launcher.technic.rest.RestNews;

public class NewsBox extends JComponent {
	private static final long serialVersionUID = 1L;

	private JTextArea messageArea;
	private LiteButton title;

	public NewsBox() {
		initComponents();
	}

	public void initComponents() {
		title = new LiteButton("");
		title.setBounds(0, 0, 660, 20);
		title.setFont(MetroLoginFrame.getMinecraftFont(14));
		title.setForeground(Color.BLACK);

		messageArea = new JTextArea();
		messageArea.setBounds(0, 20, 660, 20);
		messageArea.setFont(MetroLoginFrame.getOtherFont(14));
		messageArea.setForeground(new Color(230, 230, 230));
		messageArea.setBackground(new Color(0, 0, 0, 100));
		messageArea.setOpaque(true);
		messageArea.setDisabledTextColor(new Color(230, 230, 230));
		messageArea.setEnabled(false);
		messageArea.setLineWrap(true);
		messageArea.setWrapStyleWord(true);
		
		add(title);
		add(messageArea);
	}

	public void addNews(RestNews news) {
		title.setText(news.getTitle());
		news.updateNewsPane(messageArea);
	}
}
