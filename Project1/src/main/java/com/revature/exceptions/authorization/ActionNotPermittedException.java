package com.revature.exceptions.authorization;

public class ActionNotPermittedException extends AuthorizationException {

	public ActionNotPermittedException() {
		super();
	}

	public ActionNotPermittedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ActionNotPermittedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ActionNotPermittedException(String message) {
		super(message);
	}

	public ActionNotPermittedException(Throwable cause) {
		super(cause);
	}
}
