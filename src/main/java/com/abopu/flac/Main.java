package com.abopu.flac;

import com.abopu.flac.headers.Header;
import com.abopu.flac.headers.StreamInfo;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chris Babstock &lt;cbabstock@compusult.net&gt;
 */
public class Main {

	public static final File FILE1 = new File("D:\\001-flac_24.flac");
	public static final File FILE2 = new File("D:\\002-flac_24.flac");
	public static final File FILE3 = new File("D:\\003.flac");

	private static final byte[] MAGIC_NUMBER = {0x66, 0x4C, 0x61, 0x43};

	public static void main(String[] args) throws Exception {
		try (InputStream is = Files.newInputStream(FILE3.toPath())) {
			byte[] magicNumber = new byte[4];

			is.read(magicNumber);
			if (magicNumber != MAGIC_NUMBER) {
				System.err.println("Not a valid FLAC file: Missing magic number.");
				System.exit(0);
			}

			Header[] headers = Header.getHeaders(is);
		}
	}
}
