package com.gng.algorithm;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 * @author gchyoo
 *
 */
public class MockExam {
	private final int[][] people = {
			{1, 2, 3, 4, 5},
			{2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
	};
	
	public int[] solution(int[] answers) {
		int[] count = new int[3];
		
		for(int i=0; i < people.length; i++) {
			int[] person = people[i];
			
			for(int j=0; j < answers.length; j++) {
				if(answers[j] == person[j % person.length]) {
					count[i]++;
				}
			}
			
		}
		
		int max = -1;
		for(int i=0; i<count.length; i++) {
			max = count[i] > max ? count[i] : max;
		}
		
		int maxCount = 0;
		for(int i=0; i<count.length; i++) {
			if(max == count[i]) {
				maxCount++;
			}
		}
		
		int[] answer = new int[maxCount];
		
		int j = 0;
		for(int i=0; i<count.length; i++) {
			if(max == count[i]) {
				answer[j] = i + 1;
				j++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		
		System.out.println(new MockExam().solution(answers));

	}

}
