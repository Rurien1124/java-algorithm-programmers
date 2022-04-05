package com.gng.algorithm;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12949
 * @author gchyoo
 *
 */
public class MulMatrix {
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];
		
		/**
		arr1[0][0] * arr2[0][0] + arr1[0][1] * arr2[1][0];
		arr1[0][0] * arr2[0][1] + arr1[0][1] * arr2[1][1];
		arr1[1][0] * arr2[0][0] + arr1[1][1] * arr2[1][0];
		...
		*/
		for(int i=0; i<arr1.length; i++) {// 1번 행렬 y축
			for(int j=0; j<arr2[0].length; j++) {// 2번 행렬 y축
				for(int k=0; k<arr1[0].length; k++) {// 1번 행렬 x축
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		
	}
}