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
			// �õ�Ƚ�� �߰�
			answer++;
			
			// 1�ϰ�� �ٷ� ����
			if(num == 1) {
				break;
			}
			
			// ¦��/Ȧ�� üũ�Ͽ� ��� ����
			if(num % 2 == 0) {
				num = num / 2;
			} else if(num % 2 == 1){
				num = (num * 3) + 1;
			}
			
			// ��� ����� 1�ϰ�� ����
			if(num == 1) {
				break;
			}
			
			// �õ�Ƚ���� 500�� �Ѿ ��� -1�� ��ȯ�ϰ� ����
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
