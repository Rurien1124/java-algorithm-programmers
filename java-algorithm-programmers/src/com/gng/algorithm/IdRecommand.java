package com.gng.algorithm;

public class IdRecommand {

	public static String solution(String newId) {
		newId = newId.toLowerCase()
				.replaceAll("[^0-9a-z-_\\.]", "")
				.replaceAll("\\*", "")
				.replaceAll("(\\.){2,}", ".")
				.replaceAll("(^\\.)|(\\.$)", "");
		
		if(newId.isEmpty()) {
			newId += "a";
		}
		
		if(newId.length() >= 16) {
			if(newId.substring(14, 15).equals(".")) {
				newId = newId.substring(0, 14);
			} else {
				newId = newId.substring(0, 15);
			}
		}
		
		while(newId.length() < 3) {
			newId += newId.charAt(newId.length() - 1);
		}
		
		String answer = newId;
		return answer;
	}
	
	public static void main(String[] args) {
		String newId = "z-+.^.";
		
		System.out.println(solution(newId));
	}
}
