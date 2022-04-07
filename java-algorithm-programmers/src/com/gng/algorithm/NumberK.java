package com.gng.algorithm;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 * @author gchyoo
 *
 */
public class NumberK {

	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		int i = 0;
		for(int[] command : commands) {
			// command에 따라서 배열 자름
			int[] subArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
			
			Arrays.sort(subArray);
			
			answer[i] = subArray[command[2] - 1];
			i++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {
				{2,5,3},
				{4,4,1},
				{1,7,3}
		};
		
		System.out.println(
				Arrays.stream(new NumberK().solution(array, commands))
						.boxed()
						.collect(Collectors.toList())
				);
	}

}
