package com.gng.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Prefix sum practice
 * @author gchyoo
 *
 */
public class PrefixSum {
	
	public static int prefixSum(int[] n, int[] a) {
		Map<String, Integer> resultMap = new HashMap<>();
		
		for(int i=0; i<n.length; i++) {
			int sum = 0;
			
			for(int j=i; j<n.length; j++) {
				sum += n[j];
				String key = String.format("%d%d", i+1, j+1);
				resultMap.put(key, sum);
//				System.out.println(String.format("[key=%s] [sum=%d]", key, sum));
			}
		}
		
		return resultMap.get(String.format("%d%d", a[0], a[1]));
	}
	
	public static void main(String[] args) {
		int[] n = {1,2,3,4,5,6,7,8};
		int[][] a = {{1,4}, {1,5}, {3,5}};
		
		Arrays.asList(a).stream()
				.map(element -> prefixSum(n,element))
				.forEach(System.out::println);
	}
}
