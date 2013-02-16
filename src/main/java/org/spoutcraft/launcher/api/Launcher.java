package org.spoutcraft.launcher.api;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

import org.spoutcraft.launcher.GameLauncher;
import org.spoutcraft.launcher.GameUpdater;
import org.spoutcraft.launcher.skin.MetroLoginFrame;
import org.spoutcraft.launcher.util.FileUtils;

public class Launcher {
	private static Launcher instance;
	private final Logger logger = Logger.getLogger("org.spoutcraft.launcher.Main");
	private final GameUpdater updater;
	private final GameLauncher launcher;
	private final MetroLoginFrame loginFrame;

	public Launcher(final GameUpdater updater, final GameLauncher launcher, final MetroLoginFrame frame) {
		if (Launcher.instance != null) {
			throw new IllegalArgumentException("You can't have a duplicate launcher");
		}
		this.updater = updater;
		this.launcher = launcher;
		this.loginFrame = frame;
		logger.addHandler(new ConsoleHandler());
		instance = this;
	}

	public static GameUpdater getGameUpdater() {
		if (instance == null) {
			System.out.println("instance is null");
		}
		if (instance.updater == null) {
			System.out.println("updater is null");
		}
		return instance.updater;
	}

	public static Logger getLogger() {
		return instance.logger;
	}

	public static GameLauncher getGameLauncher() {
		return instance.launcher;
	}

	public static boolean clearCache() {
		try {
			FileUtils.deleteDirectory(instance.updater.getTempDir());
			FileUtils.deleteDirectory(instance.updater.getBinDir());
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static MetroLoginFrame getFrame() {
		return instance.loginFrame;
	}
}
