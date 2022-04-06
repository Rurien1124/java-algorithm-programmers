package com.gng.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS practice
 * @author gchyoo
 *
 */
public class DfsShortest {
	private static final int[] dx = {0,1,0,-1};
	private static final int[] dy = {-1,0,1,0};
	private static int min = 0;
	
	public static int solution(int[][] matrix) {
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		
		min = matrix.length * matrix[0].length;
		
		dfs(0, 0, 1, matrix, visited);
		
		return min;
	}
	
	public static void dfs(int x, int y, int length, int[][] matrix, boolean[][] visited) {
		// 방문으로 체크
		visited[y][x] = true;
		
		// 도착시 길이 체크하여 종료
		if(x == visited[0].length - 1 && y == visited.length - 1) {
			if(min > length) {
				min = length;
			}
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx > -1 && ny > -1 &&
					nx < visited[0].length && ny < visited.length &&
					!visited[ny][nx] && matrix[ny][nx] == 1
					) {
				System.out.println("[" + length + "][" + i + "]Move to : " + nx + "," + ny);
				dfs(nx, ny, length + 1, matrix, visited);
			}
		}
		
		// 다시 돌아가기 위해 false를 대입
		visited[y][x] = false;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1,1,1,1,1},
				{0,0,0,0,1},
				{1,1,1,1,1},
				{1,0,1,0,0},
				{1,1,1,1,1}
		};

		for(int[] x : matrix) {
			for(int node : x) {
				System.out.print(node + " ");
			}
			System.out.println();
		}
		
		System.out.println(solution(matrix));
	}

}
