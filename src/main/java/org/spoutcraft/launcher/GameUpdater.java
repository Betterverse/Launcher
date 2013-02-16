package org.spoutcraft.launcher;

import org.spoutcraft.launcher.api.Launcher;
import org.spoutcraft.launcher.api.Directories;
import org.spoutcraft.launcher.exceptions.RestfulAPIException;
import org.spoutcraft.launcher.launch.MinecraftLauncher;
import org.spoutcraft.launcher.technic.PackInfo;
import org.spoutcraft.launcher.util.DownloadListener;

public final class GameUpdater extends Directories {
	public static final String baseURL = "http://s3.amazonaws.com/MinecraftDownload/";
	public static final String latestLWJGLURL = "http://get.spout.org/lib/lwjgl/";
	public static final String spoutcraftMirrors = "http://get.spout.org/mirrors.yml";

	// Minecraft Updating Arguments
	private String user = "Player";
	private String downloadTicket = "1";
	private String minecraftPass = "";
	private String minecraftSession = "";

	private DownloadListener listener;
	private long validationTime;
	private UpdateThread updateThread;

	public GameUpdater() {
	}

	public void start(PackInfo installedPack) throws RestfulAPIException {
		if (updateThread != null) {
			return;
		}
		this.updateThread = new UpdateThread(installedPack, listener);
		MinecraftLauncher.resetClassLoader();
		System.setProperty("minecraft.applet.TargetDirectory", installedPack.getPackDirectory().getAbsolutePath());
		updateThread.start();
	}

	public boolean isFinished() {
		return updateThread.isFinished();
	}

	public void setWaiting(boolean waiting) {
		updateThread.setWaiting(waiting);
	}

	public void setStartValidationTime(long validationTime) {
		this.validationTime = validationTime;
	}

	protected void validationFinished(boolean result) {
		long end = System.currentTimeMillis();
		System.out.println("------------------ Validation Finished  ------------------");
		System.out.println("Finished in " + (end - validationTime) + "ms");
		System.out.println("Result: " + result);
	}


	public void setMinecraftUser(String user) {
		this.user = user;
	}

	public void setDownloadTicket(String downloadTicket) {
		this.downloadTicket = downloadTicket;
	}

	public String getMinecraftUser() {
		return user;
	}

	public String getDownloadTicket() {
		return downloadTicket;
	}

	public String getMinecraftPass() {
		return minecraftPass;
	}

	public String getMinecraftSession() {
		return minecraftSession;
	}

	public void setMinecraftPass(String minecraftPass) {
		this.minecraftPass = minecraftPass;
	}

	public void setMinecraftSession(String minecraftSession) {
		this.minecraftSession = minecraftSession;
	}

	public DownloadListener getDownloadListener() {
		return listener;
	}

	public void setDownloadListener(DownloadListener listener) {
		this.listener = listener;
	}

	public void stateChanged(String message, float progress) {
		if (listener != null) {
			listener.stateChanged(message, progress);
		}
	}

	public void runGame() {
		Launcher.getGameLauncher().runGame(user, minecraftSession, downloadTicket, Launcher.getFrame().getSelector().getSelectedPack());
	}
}
