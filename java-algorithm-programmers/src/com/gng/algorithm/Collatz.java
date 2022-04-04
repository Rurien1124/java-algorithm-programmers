package com.gng.algorithm;

/**
 * https://programmers.co.kr/skill_checks/352347
 * @author gchyoo
 *
 */
public class Collatz {
	public int solution(int num) {
		int answer = 0;
		
		while(true) {
			// 시도횟수 추가
			answer++;
			
			// 1일경우 바로 종료
			if(num == 1) {
				break;
			}
			
			// 짝수/홀수 체크하여 계산 실행
			if(num % 2 == 0) {
				num = num / 2;
			} else if(num % 2 == 1){
				num = (num * 3) + 1;
			}
			
			// 계산 결과가 1일경우 종료
			if(num == 1) {
				break;
			}
			
			// 시도횟수가 500을 넘어갈 경우 -1을 반환하고 종료
			if(answer >= 500) {
				answer = -1;
				break;
			}
			
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int num = 626331;
		
		System.out.println(new Collatz().solution(num));
	}

}
