package com.abopu.flac.headers;

import com.abopu.flac.exceptions.InvalidFlacFormatException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chris Babstock &lt;cbabstock@compusult.net&gt;
 */
public final class MetadataFactory {

	/***************************************************************************
	 *
	 * Static API
	 *
	 **************************************************************************/

	public static StreamInfo getStreamInfo(InputStream is) throws IOException {
		byte[] metadataHeader = new byte[4];

		is.mark(4);
		is.read(metadataHeader);

		if (metadataHeader != new byte[] {0x0, 0x0, 0x0, 34}) {
			is.reset();
			throw new InvalidFlacFormatException("Missing or invalid STREAMINFO header.");
		}

		byte[] data = new byte[34];
		is.read(data);
		return new StreamInfo(data);
	}

	public static Map<Header.Type, Header> getMetadata(InputStream is) throws IOException {
		Map<Header.Type, Header> headers = new HashMap<>();

		while (true) {
			is.mark(1);
			byte b = (byte) is.read();
			if (b == (byte) 0xFF) {
				is.reset();
				break;
			}

			Header.Type type = Header.Type.forId(b);
			int size = getDataLength(is);

			byte[] data = new byte[size];
			is.read(data);

			headers.put(type, getMetadata(type, data));
		}
	}

	private static Header getMetadata(Header.Type type, byte[] data) {
		switch (type) {
			case STREAMINFO:
				break;
			case PADDING:
				break;
			case APPLICATION:
				break;
			case SEEKTABLE:
				break;
			case VORBIS_COMMENT:
				break;
			case CUESHEET:
				break;
			case PICTURE:
				break;
		}
	}

	private static int getDataLength(InputStream is) throws IOException {
		byte[] sizeBytes = new byte[3];
		is.read(sizeBytes);

		return ByteBuffer.wrap(sizeBytes).getInt();
	}
}
