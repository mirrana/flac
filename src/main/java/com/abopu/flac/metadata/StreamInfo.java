package com.abopu.flac.metadata;

import com.abopu.flac.MD5Hash;

/**
 * @author Sarah Skanes &lt;agent154@abopu.comt&gt;
 */
public class StreamInfo extends Metadata {

	private Short minBlockSize;
	private Short maxBlockSize;
	private Integer minFrameSize;
	private Integer maxFrameSize;
	private Integer sampleRate;
	private Byte numChannels;
	private Byte bitsPerSample;
	private Long totalSamples;
	private byte[] md5 = new byte[16];

	public StreamInfo(byte[] header) {
		super(Type.STREAMINFO);

		minBlockSize = (short) ((header[0] << 8) | header[1]); // 16 bits
		maxBlockSize = (short) ((header[2] << 8) | header[3]); // 16 bits
		minFrameSize = (header[4] << 16) | (header[5] << 8) | header[6]; // 24 bits
		maxFrameSize = (header[7] << 16) | (header[8] << 8) | header[9]; // 24 bits
		sampleRate = (header[10] << 12) | (header[11] << 4) | (header[12] >>> 4); // 20 bits
		numChannels = (byte) (((header[12] & 0x0F) >>> 1) + 1); // 3 bits
		bitsPerSample = (byte) ((((header[12] & 0x01) << 4) | header[13] >>> 4) + 1); // 5 bits
		totalSamples = (long) (((header[13] & 0x0F ) << 28) | (header[14] << 24) | (header[15] << 16) | (header[16] << 8) | header[17]); // 36 bits
		System.arraycopy(header, header.length - md5.length, md5, 0, md5.length); // 128 bits
	}

	@Override
	public String toString() {
		return "StreamInfo{" +
				"minBlockSize=" + Short.toUnsignedLong(minBlockSize) +
				", maxBlockSize=" + Short.toUnsignedLong(maxBlockSize) +
				", minFrameSize=" + Integer.toUnsignedLong(minFrameSize) +
				", maxFrameSize=" + Integer.toUnsignedLong(maxFrameSize) +
				", sampleRate=" + Integer.toUnsignedLong(sampleRate) +
				", numChannels=" + Byte.toUnsignedLong(numChannels) +
				", bitsPerSample=" + Byte.toUnsignedLong(bitsPerSample) +
				", totalSamples=" + (totalSamples & 0x0000000FFFFFFFFFL) +
				", md5=" + MD5Hash.toHexString(md5) +
				'}';
	}
}
