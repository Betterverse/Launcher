package org.spoutcraft.launcher.util;

public enum FileType {
	JINPUT("a7835a73a130656aba23e34147a55367"),
	LWJGL("7a07c4285fa9a6b204ba59f011f1cd77"),
	LWJGL_UTIL("f00470751cfc093ba760ca3cf10a512c"),
	MINECRAFT("8e80fb01b321c6b3c7efca397a3eea35");

	private final String md5;
	private FileType(String md5) {
		this.md5 = md5;
	}

	public String getMD5() {
		return md5;
	}

	public String getMD5(String version) {
		if (this == MINECRAFT && "1.4.7".equals(version)) {
			return "8e80fb01b321c6b3c7efca397a3eea35";
		}
		if (this == MINECRAFT && "1.4.6".equals(version)) {
			return "48677dc4c2b98c29918722b5ab27b4fd";
		}
		if (this == MINECRAFT && "1.4.5".equals(version)) {
			return "b15e2b2b6b4629f0d99a95b6b44412a0";
		}
		if (this == MINECRAFT && "1.3.2".equals(version)) {
			return "969699f13e5bbe7f12e40ac4f32b7d9a";
		}
		if (this == MINECRAFT && "1.2.5".equals(version)) {
			return "8e8778078a175a33603a585257f28563";
		}
		if (this == MINECRAFT && "1.2.3".equals(version)) {
			return "12f6c4b1bdcc63f029e3c088a364b8e4";
		}
		return md5;
	}

	@Override
	public String toString() {
		return super.name().toLowerCase();
	}
}
