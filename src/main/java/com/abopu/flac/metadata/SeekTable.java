package com.abopu.flac.metadata;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created: March 02, 2019.
 *
 * @author Sarah Skanes
 */
public class SeekTable extends Metadata {
	
	List<SeekPoint> seekPoints = new ArrayList<>();
	
	public SeekTable(byte[] data) {
		super(Type.SEEKTABLE);

		ByteBuffer buffer = ByteBuffer.wrap(data);
		while (buffer.hasRemaining()) {
			byte[] pointData = new byte[18];
			buffer.get(pointData);
			seekPoints.add(new SeekPoint(pointData));
		}
	}
	
	public static class SeekPoint {
		long firstSample;
		long offset;
		short numSamples;
		
		public SeekPoint(byte[] data) {
			ByteBuffer buffer = ByteBuffer.wrap(data);
			firstSample = buffer.getLong();
			offset = buffer.getLong();
			numSamples = buffer.getShort();
		}
	}
}
