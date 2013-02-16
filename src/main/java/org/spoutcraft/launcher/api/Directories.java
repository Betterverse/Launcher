package org.spoutcraft.launcher.api;

import java.io.File;

import org.spoutcraft.launcher.util.Utils;

public class Directories {
	private File workingDir;
	private File backupDir;
	private File binDir;
	private File cacheDir;
	private File configDir;
	private File savesDir;
	private File tempDir;
	private File resourceDir;

	public void setWorkingDir(String directory) {
		workingDir = new File(Utils.getLauncherDirectory(), directory);

		backupDir = new File(workingDir, "backups");
		binDir = new File(workingDir, "bin");
		cacheDir = new File(binDir, "cache");
		configDir = new File(workingDir, "config");
		savesDir = new File(workingDir, "saves");
		tempDir = new File(workingDir, "temp");
		resourceDir = new File(workingDir, "resources");

		backupDir.mkdirs();
		binDir.mkdirs();
		cacheDir.mkdirs();
		configDir.mkdirs();
		savesDir.mkdirs();
		tempDir.mkdirs();
		resourceDir.mkdirs();

		System.setProperty("minecraft.applet.TargetDirectory", workingDir.getAbsolutePath());
	}

	public final File getWorkingDir() {
		return workingDir;
	}

	public final File getBinDir() {
		return binDir;
	}

	public final File getCacheDir() {
		return cacheDir;
	}

	public final File getBackupDir() {
		return backupDir;
	}

	public final File getConfigDir() {
		return configDir;
	}

	public final File getSavesDir() {
		return savesDir;
	}

	public final File getTempDir() {
		return tempDir;
	}

	public final File getResourceDir() {
		return resourceDir;
	}
}
