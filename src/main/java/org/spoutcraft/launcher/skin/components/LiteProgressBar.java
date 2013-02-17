package org.spoutcraft.launcher.skin.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JProgressBar;

public class LiteProgressBar extends JProgressBar implements Transparent{
	private static final long serialVersionUID = 1L;
	private final TransparentComponent transparency = new TransparentComponent(this, false);

	public LiteProgressBar() {
		setFocusable(false);
		setOpaque(false);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) transparency.setup(g);

		// Draw bar
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth(), getHeight());

		// Draw progress
		g2d.setColor(Color.BLUE);
		int x = (int) (getWidth() * getPercentComplete());
		g2d.fillRect(0, 0, x, getHeight());

		transparency.cleanup(g2d);
		g2d = (Graphics2D) g;

		if (this.isStringPainted() && getString().length() > 0) {
			g2d.setFont(getFont());
			
			final int startWidth = (getWidth() - g2d.getFontMetrics().stringWidth(getString())) / 2;
			String white = "";
			int whiteWidth = 0;
			int chars = 0;
			for (int i = 0; i < getString().length(); i++) {
				white += getString().charAt(i);
				whiteWidth = g2d.getFontMetrics().stringWidth(white);
				if (startWidth + whiteWidth > x) {
					break;
				}
				chars++;
			}
			if (chars != getString().length()) {
				white = white.substring(0, white.length() - 1);
				whiteWidth = g2d.getFontMetrics().stringWidth(white);
			}
			float height = getFont().getSize();
			g2d.setColor(Color.WHITE);
			g2d.drawString(white, startWidth, height);
			g2d.setColor(Color.BLACK);
			g2d.drawString(this.getString().substring(chars), whiteWidth + startWidth, height);
		}

		transparency.cleanup(g2d);
	}

	@Override
	public float getTransparency() {
		return transparency.getTransparency();
	}

	@Override
	public void setTransparency(float t) {
		transparency.setTransparency(t);
	}

	@Override
	public float getHoverTransparency() {
		return transparency.getHoverTransparency();
	}

	@Override
	public void setHoverTransparency(float t) {
		transparency.setHoverTransparency(t);
	}
}
