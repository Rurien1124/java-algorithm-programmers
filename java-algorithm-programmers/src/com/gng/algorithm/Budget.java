package com.gng.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/skill_checks/352344
 * @author gchyoo
 *
 */
public class Budget {

	public int solution(int[] d, int budget) {
		int answer = 0;
		int usedBudget = 0;
		
		List<Integer> requestList = Arrays.stream(d)
				.boxed()
				.collect(Collectors.toList());
		
		while(true) {
			if(requestList.size() > 0 ) {
				int minRequest = Collections.min(requestList);
				requestList.remove(Collections.min(requestList));
				
				if((usedBudget + minRequest) <= budget) {
					usedBudget += minRequest;
					answer++;
				} else {
					break;
				}
			} else {
				break;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] requests = {1,3,2,5,4};
		int budget = 9;
		
		System.out.println(new Budget().solution(requests, budget));
	}

}
