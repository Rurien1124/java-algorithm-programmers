package com.gng.algorithm;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/1829
 * DFS/BFS 
 * @author gchyoo
 *
 */
public class Coloring {
	private int[] dx = {0, 1, 0, -1};
	private int[] dy = {-1, 0, 1, 0};
	
	private int areaCount = 0;
	private int areaWidest = 0;
	private int nodeCount = 0;
	
	public int[] solution(int y, int x, int[][] picture) {
		boolean[][] isVisited = new boolean[y][x];
		
		for(int i=0; i<picture.length; i++) {
			for(int j=0; j<picture[0].length; j++) {
				if(!isVisited[i][j] && picture[i][j] != 0) {
					dfs(j, i, picture[i][j], isVisited, picture);
					areaWidest = Math.max(areaWidest, nodeCount);
					nodeCount = 0;
					areaCount++;
					System.out.println("===================================");
				}
			}
		}
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				System.out.print("[" + i + "][" + j + "]" + isVisited[i][j] + "\t");
			}
			System.out.println("");
		}
		
		int[] answer = new int[2];
		answer[0] = areaCount;
		answer[1] = areaWidest;
		return answer;
	}
	
	private void dfs(int x, int y, int color, boolean[][] isVisited, int[][] picture) {
		// 방문 처리
		isVisited[y][x] = true;
		nodeCount++;
		System.out.println(String.format("[count=%d] [current node[%d] = [%d][%d]]", nodeCount, picture[y][x], x, y));
		
		// 인접 노드 탐색
		for(int i=0; i<4; i++) {
			int addX = dx[i];
			int addY = dy[i];
			int nextX = x + addX;
			int nextY = y + addY;

			System.out.println(String.format("[[%d]next expected = [%d][%d]]", i, nextX, nextY));
			if(nextX >= 0 && nextY >= 0) { // 유효한 범위인지 확인(음수)
				if(nextX < (picture[0].length) && nextY < (picture.length)) { // 유효한 범위인지 확인(양수)
						if(
								!isVisited[nextY][nextX] && // 방문 노드인지 확인
								picture[nextY][nextX] == color // 동일한 색의 노드인지 확인
						) {
							System.out.println(String.format("[next node[%d] = [%d][%d]]", picture[nextY][nextX], nextX, nextY));
							dfs(nextX, nextY, color, isVisited, picture);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int x = 6;
		int y = 4;
		int[][] picture = {
				{1, 1, 1, 0}, 
				{1, 2, 2, 0}, 
				{1, 0, 0, 1}, 
				{0, 0, 0, 1}, 
				{0, 0, 0, 3}, 
				{0, 0, 0, 3}};
		
		for(int i : new Coloring().solution(x, y, picture)) {
			System.out.print(i + "\t");
		}
	}

}
