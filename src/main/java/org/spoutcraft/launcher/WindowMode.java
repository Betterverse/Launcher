package org.spoutcraft.launcher;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;

public enum WindowMode {
	WINDOWED("Windowed", 0),
	FULL_SCREEN("Full Screen", 1),
	MAXIMIZED("Maximized", 2);

	private static final int DEFAULT_WINDOW_HEIGHT = 540;
	private static final int DEFAULT_WINDOW_WIDTH = 900;
	private final String name;
	private final int id;
	private WindowMode(final String name, final int id) {
		this.name = name;
		this.id = id;
	}

	public String getModeName() {
		return name;
	}

	public int getId() {
		return id;
	}

	/**
	 * Gets the proper dimensions for this window based on the window mode
	 * @param window
	 * @return proper dimensions
	 */
	public Dimension getDimension(Window window) {
		Rectangle bounds;
		switch(this) {
			case WINDOWED:
				return new Dimension(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
			case FULL_SCREEN:
			case MAXIMIZED:
				bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
				return new Dimension((int)bounds.getWidth(), (int)bounds.getHeight());
			default:
				throw new IllegalArgumentException("Unknown windowmode");
		}
	}

	/**
	 * Gets the calculated centered location of the window for the predicted window mode dimensions
	 * 
	 * @param window
	 * @return centered location
	 */
	public Point getCenteredLocation(Window window) {
		Rectangle bounds;
		switch(this) {
			case WINDOWED:
				return new Point(window.getLocation().x + (window.getSize().width - DEFAULT_WINDOW_WIDTH) / 2, window.getLocation().y + (window.getSize().height - DEFAULT_WINDOW_HEIGHT) / 2);
			case FULL_SCREEN:
			case MAXIMIZED:
				bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
				return new Point(bounds.x, bounds.y);
			default:
				throw new IllegalArgumentException("Unknown windowmode");
		}
	}

	public static WindowMode getModeById(int id) {
		for (WindowMode m : values()) {
			if (m.id == id) {
				return m;
			}
		}
		throw new IllegalArgumentException("No window mode matching " + id);
	}
}
