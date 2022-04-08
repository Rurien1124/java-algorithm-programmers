package com.gng.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 * @author gchyoo
 *
 */
public class FunctionDevelopment {
	
	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> answerList = new ArrayList<>();
		Queue<Integer> progressQueue= new LinkedList<>();
		Queue<Integer> speedQueue = new LinkedList<>();
		
		Arrays.stream(progresses).boxed().forEach(progressQueue::add);
		Arrays.stream(speeds).boxed().forEach(speedQueue::add);
		
		int day = 1;
		while(!progressQueue.isEmpty()) {
			
			int distributeCount = 0;
			
			// poll에 의해 크기가 바뀌므로 고정된 값 사용
			int loopLength = progressQueue.size();
			
			// 큐의 첫 작업이 100이상이면 배포 개수++ 반복
			for(int i=0; i < loopLength; i++) {
//				System.out.println(String.format("[day=%d][i=%d][add=%d][current=%d]", day, i, (speedQueue.peek() * day), progressQueue.peek()));
				if(progressQueue.peek() + (speedQueue.peek() * day) >= 100) {
//					System.out.println(String.format("[day=%d][i=%d][finish=%d]", day, i, progressQueue.peek()));
					// 가장 앞의 작업이 완료되었으면 꺼내고 배포횟수 추가
					progressQueue.poll();
					speedQueue.poll();
					distributeCount++;
				} else {
					// 가장 앞의 작업이 완료되지 않음
//					System.out.println(String.format("[day=%d][i=%d] No function to distribute", day, i));
					break;
				}
			}
			
			//배포가 진행됐으면 배포횟수 추가
			if(distributeCount > 0) {
				answerList.add(distributeCount);
			}
			
			day++;
		}
		
		return answerList.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public static void main(String[] args) {
		int[] progresses = {20, 99, 93, 30, 55, 10};
		int[] speeds = {5, 10, 1, 1, 30, 5};
		/**
			[20, 99, 93, 30, 55, 10], [5, 10, 1, 1, 30, 5], [3, 3]
			[96, 99, 98, 97], [1, 1, 1, 1], [4]
			[40, 93, 30, 55, 60, 65], [60, 1, 30, 5, 10, 7], [1, 2, 3]
			[93, 30, 55, 60, 40, 65], [1, 30, 5, 10, 60, 7], [2, 4]
		 */
		Arrays.stream(new FunctionDevelopment().solution(progresses, speeds)).boxed().map(answer -> answer + " ").forEach(System.out::print);
	}
}
