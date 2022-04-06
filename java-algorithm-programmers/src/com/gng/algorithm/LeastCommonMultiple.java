package com.gng.algorithm;

/**
 * 
 * @author enemf
 *
 */
public class LeastCommonMultiple {
	public static int solution(int[] arr) {
		int answer = 1;
		int prevAnswer = 1;
		
		while(true) {
			for(int i=0; i<arr.length; i++) {
				if(answer % arr[i] != 0) {
					answer++;
					break;
				}
			}
			if(prevAnswer == answer) {
				break;
			}
			
			prevAnswer = answer;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,6,8,14};
		
		System.out.println(solution(arr));
	}
}
