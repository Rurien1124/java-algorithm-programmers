package com.gng.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS practice
 * @author gchyoo
 *
 */
public class Dfs {
	
	private static int[][] graph = {
			{}, // index번호 맞추는 용도
			{2,3,8},
			{1,7},
			{1,4,5},
			{3,5},
			{3,4},
			{7},
			{2,6,8},
			{1,7}
	};
	
	private static boolean[] isVisited = {false, false, false, false, false, false, false, false, false};
	private static List<Integer> visitedList = new ArrayList<>();
	
	// 1. flag 확인
	// 2. 진입 조건 확인
	
	public static void dfs(int node) {
		// 방문했으므로 true로 변경
		isVisited[node] = true;
		
		System.out.println(String.format("[current node=%d]", node));
		visitedList.add(node);
		
		// 인접 노드 탐색
		for(int i : graph[node]) {
			// 방문하지 않은 노드라면
			if(!isVisited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) {
		int startNode = 1;
		
		dfs(startNode);
	}

}
