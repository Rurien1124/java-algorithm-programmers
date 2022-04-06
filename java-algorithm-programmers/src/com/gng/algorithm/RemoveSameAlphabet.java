package com.gng.algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12973
 * @author gchyoo
 *
 */
public class RemoveSameAlphabet {
	public static int solution(String s)
	{
		/**
		 *    baabaa
		 * -> bbaa
		 * -> aa
		 * -> ''
		 */
		
		if(s.isEmpty() || s.length() % 2 != 0) return 0;
		
		Stack<String> sStack = new Stack<>();
		
		Arrays.asList(s.split("")).forEach(element -> {
						if(sStack.size() < 1) {
							// 처음엔 비어있으므로 add
							sStack.push(element);
						} else {
							if(sStack.get(sStack.size() - 1).equals(element)) {
								// 스택의 끝에 있는 항목이 현재 넣을 항목과 같으면 넣지 않고 pop
								sStack.pop();
							} else {
								// 다르면 push
								sStack.push(element);
							}
						}
				});
		
		
		return sStack.isEmpty() ? 1 : 0;
	}
	
	public static void main(String[] args) {
		String s = "baabaa";
		System.out.println(solution(s));
	}
}
