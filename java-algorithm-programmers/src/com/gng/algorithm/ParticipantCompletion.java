package com.gng.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
 * @author gchyoo
 *
 */
public class ParticipantCompletion {
	public static String solution(String[] participant, String[] completion) {
		// 참가자 <이름, 참가수> 맵
		Map<String, Integer> pcMap = new HashMap<>();
		
		// 참가자 입력(동명이인이 있으므로 숫자로 표현)
		Arrays.asList(participant).stream().forEach(p -> {
			if(pcMap.get(p) == null) {
				pcMap.put(p, 1);
			} else {
				pcMap.put(p, pcMap.get(p) + 1);
			}
		});
		
		// 참가자에서 완주자 제거
		Arrays.asList(completion).stream().forEach(c -> {
			pcMap.put(c, pcMap.get(c) - 1);
		});
		
		// 참가자가 1명 남는 이름 리턴
		return pcMap.keySet().stream().filter(pc -> pcMap.get(pc) == 1).findFirst().get();
	}
	
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"kiki", "eden"};
		
		System.out.println(solution(participant, completion));
	}
}
