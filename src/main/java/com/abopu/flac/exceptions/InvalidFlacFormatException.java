package com.abopu.flac.exceptions;

import java.io.IOException;

/**
 * @author Sarah Skanes &lt;agent154@abopu.comt&gt;
 */
public class InvalidFlacFormatException extends IOException {

	/**
	 * Constructs a new exception with the specified detail message.  The
	 * cause is not initialized, and may subsequently be initialized by
	 * a call to {@link #initCause}.
	 *
	 * @param message the detail message. The detail message is saved for
	 *                later retrieval by the {@link #getMessage()} method.
	 */
	public InvalidFlacFormatException(String message) {
		super(message);
	}
}
