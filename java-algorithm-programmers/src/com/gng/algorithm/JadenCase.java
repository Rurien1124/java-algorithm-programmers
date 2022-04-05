package com.gng.algorithm;

public class JadenCase {
	public static String solution(String s) {
		s = s.toLowerCase();
		StringBuilder stringBuilder = new StringBuilder();
		
		String[] sSplit = s.split(" ", -1);
		
		for(String str : sSplit) {
			if(str.isEmpty()) {
				stringBuilder.append(" ");
			}
			
			if(!str.isEmpty()) {
				stringBuilder.append(Character.toUpperCase(str.charAt(0)));
				
				for(int i=1; i<str.length(); i++ ) {
					stringBuilder.append(str.charAt(i));
				}
				
				stringBuilder.append(" ");
			}
		}
		
		stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
		
		String answer = stringBuilder.toString();
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution("3people  unFollowed me  "));
		System.out.println(solution(" for the last week  "));
	}
}
