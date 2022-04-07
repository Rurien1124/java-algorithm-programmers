package com.gng.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 * @author gchyoo
 *
 */
public class LargestNumber {
	public String solution(int[] numbers) {
		// 0만 들어있는지 체크
		for(int i=0; i<numbers.length; i++) {
			if(i == numbers.length - 1) {
				return "0";
			}
			
			if(numbers[i] != 0) {
				break;
			}
		}
		
		List<String> numberList = Arrays.stream(numbers).boxed().map(String::valueOf).collect(Collectors.toList());
		
		Collections.sort(numberList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				/**
				 * int로 형변환 후 (o2o1 - o1o2) 비교
				 */
				return Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2);
			}
		});
		
		return numberList.stream().map(String::valueOf).collect(Collectors.joining());
	}
	
	public static void main(String[] args) {
		int[] numbers = {5,12,456,123,9,91,990};
		System.out.println(new LargestNumber().solution(numbers));
	}

}
