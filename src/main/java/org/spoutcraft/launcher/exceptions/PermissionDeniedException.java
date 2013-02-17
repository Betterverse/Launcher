package org.spoutcraft.launcher.exceptions;

public class PermissionDeniedException extends DownloadException {
	private final Throwable cause;
	private final String message;

	public PermissionDeniedException(String message, Throwable cause) {
		this.cause = cause;
		this.message = message;
	}

	public PermissionDeniedException(Throwable cause) {
		this(null, cause);
	}

	public PermissionDeniedException(String message) {
		this(message, null);
	}

	public PermissionDeniedException() {
		this(null, null);
	}

	@Override
	public Throwable getCause() {
		return this.cause;
	}

	@Override
	public String getMessage() {
		return message;
	}

	private static final long serialVersionUID = 1L;
}
