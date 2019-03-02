package com.abopu.flac.metadata;

/**
 * @author Sarah Skanes &lt;agent154@abopu.comt&gt;
 */
public abstract class Metadata {	

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

	public Metadata(Type type) {
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
    PICTURE((byte) 0b110),
		INVALID((byte) 0b01111111);

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
