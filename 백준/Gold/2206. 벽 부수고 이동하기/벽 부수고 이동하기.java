import java.io.*;
import java.util.*;

public class Main {
	
	static int row, col;
	static int[][] map;
	static int[][][] visited;
	
	//상하좌우
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		map = new int[row][col];
		visited = new int[row][col][2]; // 0 : 벽 안부시는 경우
										// 1 : 벽을 부시는 경우
		
		for (int i = 0; i < row; i++) {
			String str = br.readLine();
			for (int j = 0; j < col; j++) {
				map[i][j] = (int)str.charAt(j)-'0';
			}
		}
		if(row == 1 && col == 1) bw.write(1+"");
		else bw.write(BFS()+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int BFS() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0,0,0});
		visited[0][0][0] = 1;
		
		while(true) {
			//dequeue
			int[] currPoint = queue.poll();
			int x = currPoint[0];
			int y = currPoint[1];
			int z = currPoint[2];// 벽 부수기 유무		
			//enqueue
			for (int i = 0; i < 4; i++) {
				int nextx = x + dx[i];
				int nexty = y + dy[i];
				// 유효성 검사
				if (nextx >= row || nextx < 0 || nexty >= col || nexty < 0) continue;
						
				// 벽을 안만나는 경우
				if (map[nextx][nexty] == 0) {
					if (visited[nextx][nexty][z] == 0) {
						queue.offer(new int[] {nextx, nexty, z});
						visited[nextx][nexty][z] = visited[x][y][z] + 1;
						if (nextx == row - 1 && nexty == col - 1) {
							return visited[nextx][nexty][z];
						}
					}
				} 
				// 벽을 만나는 경우
				else {
					if (z == 0) {
						if (visited[nextx][nexty][1] == 0) {
							queue.offer(new int[] {nextx, nexty, 1});
							visited[nextx][nexty][1] = visited[x][y][0] + 1;
							if (nextx == row - 1 && nexty == col - 1) {
								return visited[nextx][nexty][1];
							}
						}
					}
				}
			}
			if (queue.isEmpty()) return -1;
		}//while문
	}//BFS()
}//main