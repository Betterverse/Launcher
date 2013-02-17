package org.spoutcraft.launcher.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResourceUtils {
	public static InputStream getResourceAsStream(String path) {
		InputStream stream = ImageUtils.class.getResourceAsStream(path);
		String[] split = path.split("/");
		path = split[split.length - 1];
		if (stream == null) {
			File resource = new File(".\\src\\main\\resources\\" + path);
			if (resource.exists()) {
				try {
					stream = new BufferedInputStream(new FileInputStream(resource));
				} catch (IOException ignore) { }
			}
		}
		return stream;
	}
	
	public static File getResourceAsFile(String path) {
		File file = new File(".\\src\\main\\resources\\" + path);
		if (file.exists())
			return file;
		else
			return null;
	}
}
