package org.spoutcraft.launcher.exceptions;

public class InvalidDescriptionFileException extends Exception {
	private static final long serialVersionUID = 1424408665150176335L;
	private final Throwable cause;
	private final String message;

	public InvalidDescriptionFileException(Throwable throwable) {
		this(throwable, "Invalid skin.yml");
	}

	public InvalidDescriptionFileException(String message) {
		this(null, message);
	}

	public InvalidDescriptionFileException(Throwable throwable, String message) {
		this.cause = null;
		this.message = message;
	}

	public InvalidDescriptionFileException() {
		this(null, "Invalid skin.yml");
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
