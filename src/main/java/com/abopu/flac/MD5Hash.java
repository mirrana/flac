package com.abopu.flac;

/**
 * Java program to generate MD5 hash or digest for String. In this example
 * we will see 3 ways to create MD5 hash or digest using standard Java API,
 * Spring framework and open source library, Apache commons codec utilities.
 * Generally MD5 has are represented as Hex String so each of this function
 * will return MD5 hash in hex format.
 *
 * @author Javin Paul
 */
public class MD5Hash {

	public static String toHexString(byte[] bytes) {
		StringBuilder hexString = new StringBuilder();

		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(0xFF & bytes[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}

		return hexString.toString();
	}
}