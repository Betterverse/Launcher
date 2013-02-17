package org.spoutcraft.launcher.util;

import java.io.File;
import java.io.IOException;

import org.spoutcraft.diff.JBPatch;
import org.spoutcraft.launcher.rest.Versions;
import org.spoutcraft.launcher.technic.PackInfo;
import org.spoutcraft.launcher.technic.rest.Modpack;
import org.spoutcraft.launcher.technic.rest.RestAPI;
import org.spoutcraft.launcher.util.Download.Result;

public class MinecraftDownloadUtils {
	public static void downloadMinecraft(String user, String output, PackInfo pack, Modpack build, DownloadListener listener) throws IOException {
		int tries = 3;
		File outputFile = null;
		while (tries > 0) {
			System.out.println("Starting download of minecraft, with " + tries + " tries remaining");
			tries--;
			Download download = new Download(RestAPI.getMinecraftURL(user), output);
			download.setListener(listener);
			download.run();
			if (download.getResult() != Result.SUCCESS) {
				if (download.getOutFile() != null) {
					download.getOutFile().delete();
				}
				System.err.println("Download of Minecraft failed!");
				if (listener != null) {
					listener.stateChanged("Download failed, retries remaining: " + tries, 0F);
				}
			} else {
				String minecraftMD5 = FileType.MINECRAFT.getMD5();
				//String minecraftMD5 = MD5Utils.getMD5(FileType.MINECRAFT, build.getLatestMinecraftVersion());
				String resultMD5 = MD5Utils.getMD5(download.getOutFile());
				System.out.println("Expected MD5: " + minecraftMD5 + " Result MD5: " + resultMD5);
				if (resultMD5.equals(minecraftMD5) || minecraftMD5 == null) {
					//Patch Minecraft
					if (!Versions.getLatestMinecraftVersion().equals(build.getMinecraftVersion())) {
						File patch = new File(pack.getPackDirectory(), "mc.patch");
						Download patchDownload = DownloadUtils.downloadFile(RestAPI.getPatchURL(build), patch.getPath(), null, null, listener);
						if (patchDownload.getResult() == Result.SUCCESS) {
							File patchedMinecraft = new File(pack.getTempDir(), "patched_minecraft.jar");
							patchedMinecraft.delete();
							JBPatch.bspatch(download.getOutFile(), patchedMinecraft, patch);
							//minecraftMD5 = MD5Utils.getMD5(FileType.MINECRAFT, build.getMinecraftVersion());
							minecraftMD5 = FileType.MINECRAFT.getMD5(build.getMinecraftVersion());
							resultMD5 = MD5Utils.getMD5(patchedMinecraft);

							if (minecraftMD5.equalsIgnoreCase(resultMD5)) {
								outputFile = download.getOutFile();
								download.getOutFile().delete();
								Utils.copy(patchedMinecraft, download.getOutFile());
								patchedMinecraft.delete();
								patch.delete();
								break;
							}
						}
					} else {
						outputFile = download.getOutFile();
						break;
					}
				}
			}
		}
		if (outputFile == null) {
			throw new IOException("Failed to download Minecraft!");
		}
		Utils.copy(outputFile, new File(pack.getCacheDir(), "minecraft_" + build.getMinecraftVersion() + ".jar"));
	}
}
