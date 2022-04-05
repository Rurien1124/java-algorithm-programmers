package com.gng.practice;

/**
 * Recursion practice
 * @author gchyoo
 *
 */
public class Recursion {
	
	public static int fibonacci(int index) {
		if(index == 0 || index == 1) {
			return index;
		}
		
		return fibonacci(index - 1) + fibonacci(index - 2);
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacci(10));
	}

}
