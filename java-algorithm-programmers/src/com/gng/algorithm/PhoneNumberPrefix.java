package com.gng.algorithm;

import java.util.Arrays;

public class PhoneNumberPrefix {
	public static boolean solution(String[] phone_book) {
		// 정렬
		Arrays.sort(phone_book);
		
		// 전화번호 접두어가 같으면 false return
		for(int i=0; i<phone_book.length - 1; i++) {
			if(phone_book[i + 1].startsWith(phone_book[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String[] phone_book1 = {"12","123","1235","567","88"};
		System.out.println(solution(phone_book1));
		String[] phone_book2 = {"119", "97674223", "99999999999999999999999"};
		System.out.println(solution(phone_book2));
		String[] phone_book3 = {"1", "444356", "4434", "44445"};
		System.out.println(solution(phone_book3));
	}

}
