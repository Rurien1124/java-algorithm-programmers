package com.gng.algorithm;

import java.util.Arrays;

public class GymCloth {
	public int solution(int n, int[] lost, int[] reserve) {
		
		Arrays.sort(lost);
		Arrays.sort(reserve);
		int[] clothes = new int[n];
		
		// 전체 옷을 1로 초기화
		Arrays.fill(clothes, 1);

		// 잃어버림, 여벌 계산
		Arrays.stream(reserve).boxed().forEach(p -> clothes[p - 1] += 1);
		Arrays.stream(lost).boxed().forEach(p -> clothes[p - 1] -= 1);

		for(int i=0; i<lost.length; i++) {
			int lostp = lost[i] - 1;
			if(clothes[lostp] > 0) {
				continue;
			}
			int prevp = lostp - 1;
			int nextp = lostp + 1;
			
			if(prevp > -1 && clothes[prevp] > 1) {
				clothes[lostp] = 1;
				clothes[prevp] -= 1;
			} else if(nextp < n && clothes[nextp] > 1) {
				clothes[lostp] = 1;
				clothes[nextp] -= 1;
			}

		}

		return Arrays.stream(clothes).boxed().filter(p -> p > 0).map(p -> p > 0 ? 1 : 0).mapToInt(p -> p).sum();
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {1,2};
		int[] reserve = {2,3};
		
		System.out.println(new GymCloth().solution(n, lost, reserve));
	}

}
