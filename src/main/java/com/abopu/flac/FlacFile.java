//package com.abopu.flac;
//
//import com.abopu.flac.exceptions.NotAFlacFileException;
//import com.abopu.flac.metadata.Metadata;
//import com.abopu.flac.metadata.MetadataFactory;
//import com.abopu.flac.metadata.StreamInfo;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Map;
//
///**
// * @author Sarah Skanes &lt;agent154@abopu.comt&gt;
// */
//public final class FlacFile implements AutoCloseable {
//
//	/***************************************************************************
//	 *
//	 * Constants
//	 *
//	 **************************************************************************/
//
//	private static final byte[] MAGIC_NUMBER = {0x66, 0x4C, 0x61, 0x43};
//
//
//
//	/***************************************************************************
//	 *
//	 * Local Variables
//	 *
//	 **************************************************************************/
//
//	private InputStream inputStream;
//
//	private final StreamInfo STREAM_INFO_HEADER;
//	private final Map<Metadata.Type, Metadata> METADATA_HEADERS;
//
//
//
//	/***************************************************************************
//	 *
//	 * Constructors
//	 *
//	 **************************************************************************/
//
//	public FlacFile(String fileName) throws IOException {
//		this(fileName != null ? new File(fileName) : null);
//	}
//
//	public FlacFile(File file) throws IOException {
//		inputStream = new FileInputStream(file);
//
//		byte[] b = new byte[4];
//		int i = inputStream.read(b);
//
//		if (i < 4 || b != MAGIC_NUMBER) {
//			throw new NotAFlacFileException(file.getName());
//		}
//
//		STREAM_INFO_HEADER = MetadataFactory.readStreamInfo(inputStream);
//		METADATA_HEADERS = MetadataFactory.getMetadata(inputStream);
//	}
//
//
//
//	/***************************************************************************
//	 *
//	 * Public API
//	 *
//	 **************************************************************************/
//
//	public void close() throws IOException {
//		inputStream.close();
//	}
//
//
//
//	/***************************************************************************
//	 *
//	 * Private API
//	 *
//	 **************************************************************************/
//
//
//}
