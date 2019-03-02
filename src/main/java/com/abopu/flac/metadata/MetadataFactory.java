package com.abopu.flac.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sarah Skanes &lt;agent154@abopu.com&gt;
 */
public final class MetadataFactory {

	/***************************************************************************
	 *
	 * Static API
	 *
	 **************************************************************************/

	public static Map<Metadata.Type, Metadata> getMetadata(InputStream is) throws IOException {
		Map<Metadata.Type, Metadata> headers = new HashMap<>();

		while (true) {
			is.mark(1);
			byte b = (byte) is.read();
			
			// Check for invalid header, indicating end of metadata
			if (((b & 0b10000000) >> 7) == 1) {
				// Consume unused data block
				int size = getDataLength(is);
				byte[] data = new byte[size];
				is.read(data);
				
				return headers;
			}

			Metadata.Type type = Metadata.Type.forId(b);
			int size = getDataLength(is);

			byte[] data = new byte[size];
			is.read(data);

			headers.put(type, getMetadata(type, data));
		}
	}

	private static Metadata getMetadata(Metadata.Type type, byte[] data) throws IOException {
		switch (type) {
			case STREAMINFO:
				return new StreamInfo(data);
			case PADDING:
				break;
			case APPLICATION:
				break;
			case SEEKTABLE:
				return new SeekTable(data);
			case VORBIS_COMMENT:
				return new VorbisComment(data);
			case CUESHEET:
				break;
			case PICTURE:
				break;
		}
		
		return null;
	}

	private static int getDataLength(InputStream is) throws IOException {
		byte[] sizeBytes = new byte[4];
		is.read(sizeBytes, 1, 3);

		return ByteBuffer.wrap(sizeBytes).getInt();
	}
}
