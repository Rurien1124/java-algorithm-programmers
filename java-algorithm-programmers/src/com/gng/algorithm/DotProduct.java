package com.gng.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/skill_checks/352347
 * @author gchyoo
 *
 */
public class DotProduct {
	public int solution(int[] a, int[] b) {
		int answer = 0;
		
		List<Integer> aList = Arrays.stream(a)
				.boxed()
				.collect(Collectors.toList());
		List<Integer> bList = Arrays.stream(b)
				.boxed()
				.collect(Collectors.toList());
		
		for(int i=0; i < aList.size(); i++) {
			answer += aList.get(i) * bList.get(i);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		
		System.out.println(new DotProduct().solution(a, b));
	}

}
