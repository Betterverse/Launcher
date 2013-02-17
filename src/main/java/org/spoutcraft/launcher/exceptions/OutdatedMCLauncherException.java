package org.spoutcraft.launcher.exceptions;

public class OutdatedMCLauncherException extends Exception {
	private static final long serialVersionUID = 4494882226742852432L;
	private final Throwable cause;
	private final String message;

	public OutdatedMCLauncherException(String message) {
		this(null, message);
	}

	public OutdatedMCLauncherException(Throwable throwable, String message) {
		this.cause = null;
		this.message = message;
	}

	public OutdatedMCLauncherException() {
		this(null, "Outdated laucher exception");
	}

	@Override
	public Throwable getCause() {
		return this.cause;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
