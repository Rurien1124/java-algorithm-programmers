package com.gng.algorithm;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 * @author gchyoo
 *
 */
public class CharacterCompression {
	public int solution(String s) {
		/**
		 * a a b b a c c c
		 * aa bb ac cc
		 * aab bac cc
		 * aabb accc
		 */
		/**
		 * a b a b c d c d a b a b c d c d
		 * ab ab cd cd ab ab cd cd
		 * aba bcd cda bab cdc d
		 * abab cdcd abab cdcd
		 * ababc dcdab abcdc d
		 * ababcd cdabab cdcd
		 * ababcdc dababcd cd
		 * ababcdcd ababcdcd
		 * 
		 * 기준 문자열
		 * 다음에 올 문자열
		 */
		int answer = s.length();
		
		for(int i=1; i <= s.length() / 2; i++) {
			
			for(int j=i; j <= s.length(); j += i) {
				
			}
		}
		
		
		return answer;
	}

	public static void main(String[] args) {
		String[] s = {"aabbaccc", "ababcdcdababcdcd", "abcabcdede", "abcabcabcabcdededededede", "xababcdcdababcdcd"};
		
		Arrays.asList(s).forEach(new CharacterCompression()::solution);
	}

}
