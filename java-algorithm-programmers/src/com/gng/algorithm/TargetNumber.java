package com.gng.algorithm;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 * @author gchyoo
 *
 */
public class TargetNumber {
	private static int answer = 0;
	
	public static int solution(int[] numbers, int target) {
		dfs(0, 0, 0, target, numbers);
		
		return answer;
	}
	
	public static void dfs(int node, int count, int sum, int target, int[] numbers) {
		// 합이 같고, count가 주어진 numbers 길이와 동일하면 answer++ 후 종료
		if(numbers.length == count && sum == target) {
			answer++;
			return;
		}
		
		// 현재 node가 numbers의 길이보다 작으면 dfs 실행
		if(node < numbers.length) {
			// +/-를 둘다 확인해야하므로 sum을 +/-로 분리
			dfs(node + 1, count + 1, sum + numbers[node], target, numbers);
			dfs(node + 1, count + 1, sum - numbers[node], target, numbers);
		}
	}
	
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		
		System.out.println(solution(numbers, target));
	}
}
