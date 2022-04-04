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
		 * 현재 길이
		 * 기준 문자열
		 * 다음에 올 문자열
		 * 변형된 문자열
		 */
		int answer = s.length();
		
		// 이전 자르고 있는 문자열 형태
		String nextSubStringStr = "";
		
		// 몇 자씩 자를 것인지(i)
		for(int i=1; i <= s.length() / 2; i++) {
			// 압축 문자열 초기화
			String compressedStr = "";
			
			// 현재 자르고 있는 문자열 형태
			String subStringStr = "";
			
			// 압축 반복 횟수
			int iterateCount = 1;
			
			// 현재 자른 위치가 어디인지(j)
			for(int j=1; j <= s.length(); j += i) {
				// 자를 문자열 할당
				int subStringMax = i + j - 1 > s.length() ? s.length() : i + j - 1;
				int nextSubStringMin = j + i - 1 > s.length() ? s.length() : j + i - 1;
				int nextSubStringMax = subStringMax + i > s.length() ? s.length() : subStringMax + i;
				
				subStringStr = s.substring(j - 1, subStringMax);
				nextSubStringStr = s.substring(nextSubStringMin, nextSubStringMax);
				
//				System.out.println("[" + i + " " + j + "]" + subStringStr + " " + nextSubStringStr);
				
				// 다음 문자열이 같으면 iterateCount++하고 반복
				if(subStringStr.equals(nextSubStringStr)) {
					iterateCount++;
					continue;
				} else {
					if(iterateCount >= 2) {
						// 반복 2회이상이면 압축
						String formatStr = String.format("%d%s", iterateCount, subStringStr);
//						System.out.println("[ADDFMT] [" + compressedStr + "]+[" + formatStr + "]");
						compressedStr += formatStr;
					} else {
						// 반복하지 않았다면 그대로 추가
//						System.out.println("[ADD   ] [" + compressedStr + "]+[" + subStringStr + "]");
						compressedStr += subStringStr;
					}
					
					iterateCount = 1;
				}
			}
			answer = Math.min(answer, compressedStr.length());
		}
		
		return answer;
	}

	public static void main(String[] args) {
		String[] s = {"aabbaccc", "ababcdcdababcdcd", "abcabcdede", "abcabcabcabcdededededede", "xababcdcdababcdcd"};
//		String[] s = {"aabbaccc"};
		
		Arrays.asList(s).stream()
			.map(new CharacterCompression()::solution)
			.forEach(System.out::println);
	}

}
