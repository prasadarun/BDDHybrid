package com.utils;

import java.util.Random;

public class GenerateRandomString {
	
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	
	public static String generateRandomString(int length) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder(length);
		
		 for (int i = 0; i < length; i++) {
	            int randomIndex = random.nextInt(CHARACTERS.length());
	            sb.append(CHARACTERS.charAt(randomIndex));
	        }
	        
		 System.out.println("generated random String"+sb.toString()+"@gmail.com");
	        return sb.toString()+"@gmail.com";
	}
	


}
