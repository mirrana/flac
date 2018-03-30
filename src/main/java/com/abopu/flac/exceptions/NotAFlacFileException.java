package com.abopu.flac.exceptions;

import java.io.IOException;

/**
 * @author Chris Babstock &lt;cbabstock@compusult.net&gt;
 */
public class NotAFlacFileException extends IOException {

	public NotAFlacFileException(String filename) {
		super(filename);
	}
}
