package com.abopu.flac.metadata;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data structure holding VORBIS_COMMENT metadata.
 * Created: March 02, 2019.
 *
 * @author Sarah Skanes
 */
public class VorbisComment extends Metadata {
	
	String vendor;
	Map<String, String> comments;
	
	/**
	 * @param data data from VORBIS_COMMENT header (in little-endian)
	 * @throws IOException
	 */
	public VorbisComment(byte[] data) {
		super(Type.VORBIS_COMMENT);

		ByteBuffer buffer = ByteBuffer.wrap(data);
		buffer.order(ByteOrder.LITTLE_ENDIAN);

		vendor = getVendor(buffer);
		comments = getComments(buffer);
	}
	
	private String getVendor(ByteBuffer buffer) {
		int length = buffer.getInt();
		
		byte[] data = new byte[length];
		buffer.get(data);
		
		return new String(data);
	}
	
	private Map<String, String> getComments(ByteBuffer buffer) {
		Map<String, String> comments = new HashMap<>();
		
		int totalComments = buffer.getInt();
		for (int i = 0; i < totalComments; i++) {
			int length = buffer.getInt();
			byte[] data = new byte[length];
			buffer.get(data);

			String[] comment = new String(data).split("=");
			comments.put(comment[0], comment[1]);
		}
		
		return comments;
	}
}
