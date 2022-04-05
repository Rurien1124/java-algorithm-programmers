package com.gng.algorithm;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12949
 * @author gchyoo
 *
 */
public class MulArray {
	public static int solution(int []A, int []B) {
		int answer = 0;
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		for(int i=0; i<A.length; i++) {
			int j = A.length - i - 1;
			answer += A[i] * B[j];
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] A = {1,4,2};
		int[] B = {5,4,4};
		
		System.out.println(solution(A,B));
	}

}
