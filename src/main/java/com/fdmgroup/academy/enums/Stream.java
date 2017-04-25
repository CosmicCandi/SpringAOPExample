package com.fdmgroup.academy.enums;

import java.util.Random;


public enum Stream {
	JAVA, APP, PMO, COBOL, DA, MUREX, TESTING;

	public static Stream getRandom() {

		Stream[] streams = Stream.values();
		Random random = new Random();
		
		return streams[random.nextInt(streams.length)];
	}
}