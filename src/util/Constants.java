package util;

import java.io.*;

public final class Constants {

	private Constants() {
	}

	public static final int BUFFER_SIZE = 1024; // https://www.quora.com/Why-are-there-1024-bytes-in-a-kilobyte

	public static final String DIR_PROJECT = System.getProperty("user.dir");
	public static final String DIR_ASSETS = "assets";
	public static final String DIR_TEXT = "texts";
	public static final String DIR_TEXTURES = "textures";
	public static final String s = File.separator;

	// Nombres de archivos
	public static final String TEXT = getTextDir("text.txt");
	public static final String BOLA = getTextureDir("bola.png");
	public static final String BOLA_AMARILLA2 = getTextureDir("bola_amarilla2.png");

	private static String getTextDir(final String file) {
		return DIR_PROJECT + s + DIR_ASSETS + s + DIR_TEXT + s + file;
	}

	private static String getTextureDir(final String file) {
		return DIR_PROJECT + s + DIR_ASSETS + s + DIR_TEXTURES + s + file;
	}

}