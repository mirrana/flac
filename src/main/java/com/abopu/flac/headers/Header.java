package com.abopu.flac.headers;

import java.io.InputStream;

/**
 * @author Chris Babstock &lt;cbabstock@compusult.net&gt;
 */
public abstract class Header {

	/***************************************************************************
	 *
	 * Local Fields
	 *
	 **************************************************************************/

	Type type;



	/***************************************************************************
	 *
	 * Constructors
	 *
	 **************************************************************************/

	public Header(Type type) {
		this.type = type;
	}



	/***************************************************************************
	 *
	 * Classes
	 *
	 **************************************************************************/

	public enum Type {
		STREAMINFO((byte) 0b0),
		PADDING((byte) 0b1),
    APPLICATION((byte) 0b10),
    SEEKTABLE((byte) 0b11),
    VORBIS_COMMENT((byte) 0b100),
    CUESHEET((byte) 0b101),
    PICTURE((byte) 0b110);

		private byte id;

		Type(byte id) {
			this.id = id;
		}

		public static Type forId(byte id) {
			for (Type type : values()) {
				if (type.id == id) return type;
			}

			return null;
		}
	}
}
