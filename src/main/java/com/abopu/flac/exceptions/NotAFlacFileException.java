package com.abopu.flac.exceptions;

import java.io.IOException;

/**
 * @author Sarah Skanes &lt;agent154@abopu.comt&gt;
 */
public class NotAFlacFileException extends IOException {

	public NotAFlacFileException(String filename) {
		super(filename);
	}
}
