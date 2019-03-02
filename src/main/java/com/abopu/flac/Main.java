package com.abopu.flac;

import com.abopu.flac.metadata.Metadata;
import com.abopu.flac.metadata.MetadataFactory;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;

/**
 * @author Sarah Skanes &lt;agent154@abopu.com&gt;
 */
public class Main {

	public static final File FILE1 = new File("C:\\Users\\sarah\\Google Drive\\Software Development\\Projects\\flac\\001-flac_24.flac");
	public static final File FILE2 = new File("C:\\Users\\sarah\\Google Drive\\Software Development\\Projects\\flac\\002-flac_24.flac");
	public static final File FILE3 = new File("C:\\Users\\sarah\\Google Drive\\Software Development\\Projects\\flac\\003.flac");

	private static final byte[] MAGIC_NUMBER = {0x66, 0x4C, 0x61, 0x43};

	public static void main(String[] args) throws Exception {
		try (InputStream is = Files.newInputStream(FILE1.toPath())) {
			byte[] magicNumber = new byte[4];

			int read = is.read(magicNumber);
			if (!Arrays.equals(magicNumber, MAGIC_NUMBER)) {
				System.err.println("Not a valid FLAC file: Missing magic number.");
				System.exit(0);
			}

			Map<Metadata.Type, Metadata> metadata = MetadataFactory.getMetadata(is);
			System.err.println();
		}
	}
}
