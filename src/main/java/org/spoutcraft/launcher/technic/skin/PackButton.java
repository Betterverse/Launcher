package org.spoutcraft.launcher.technic.skin;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.spoutcraft.launcher.skin.MetroLoginFrame;

public class PackButton extends ImageButton {
	private static final long serialVersionUID = 1L;
	private int index;
	private JLabel label;

	public PackButton() {
		super();
		label = new JLabel("Loading...");
		label.setFont(MetroLoginFrame.getMinecraftFont(12));
		label.setForeground(Color.WHITE);
		label.setBackground(new Color(35, 35, 35));
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
	}

	@Override
	public void setIcon(Icon defaultIcon) {
		super.setIcon(defaultIcon);
		if (index == 0) {
			this.setSelectedIcon(defaultIcon);
			this.setRolloverIcon(defaultIcon);
			this.setPressedIcon(defaultIcon);
		}
	}

	public JLabel getJLabel() {
		return label;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}
