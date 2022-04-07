package com.gng.algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 * @author gchyoo
 *
 */
public class Scoville {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		
		// Min heap
		PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();
		
		// Max heap
		//PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>((Integer o1, Integer o2) -> (- Integer.compare(o1,o2)));
		
		// 전체 값을 min heap에 추가
		Arrays.stream(scoville).boxed().forEach(scovilleQueue::add);
		
		while(true) {
			// Min heap에서 최소값 두개를 가져옴(null일 수 있으므로 primitive type은 사용하지 않음)
			Integer min1 = scovilleQueue.poll();
			Integer min2 = scovilleQueue.poll();
			
			if(min1 >= K) {
				// K보다 min1이 크면 break
				break;
			} else if(min2 == null) {
				// min2가 null일 경우 더이상 진행이 불가능하므로 -1 리턴
				return -1;
			} else {
				// scoville을 계산하여 min heap에 추가
				scovilleQueue.add(min1 + (min2 * 2));
			}
			
			answer++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] scoville = {3, 2, 1, 9, 10, 12};
		int k = 7;
		
		System.out.println(new Scoville().solution(scoville, k));
	}
}
