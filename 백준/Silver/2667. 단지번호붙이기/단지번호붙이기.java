import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
	
	static int N;
	static int[] dx = { 0,  0, -1, +1};
	static int[] dy = {-1, +1,  0,  0};
	static int[][] map;
	static boolean[][] isVisited;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isVisited = new boolean[N][N];
		String[] temp = new String[N];
		for(int i = 0; i < N; i++) {
			temp = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}	
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				bfs(i,j);
			}
		}
		
		int[] danji = new int[cnt];
		for(int k = 1; k <= cnt; k++) {
			int D = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == k) D++;
				}
			}
			danji[k-1] = D;
		}
		Arrays.sort(danji);
		
		System.out.println(cnt);
		for(int i = 0; i < cnt; i++) {
			System.out.println(danji[i]);
		}
		
	}
	

	public static void bfs(int startX, int startY) {
		if(map[startX][startY]==1 && !isVisited[startX][startY]) {
			cnt++;
			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[] {startX,startY});
			isVisited[startX][startY] = true;
			map[startX][startY] = cnt;
			while(!queue.isEmpty()) {
				int[] currPoint = queue.poll();
				for(int i = 0; i < 4; i++) {
					int x = currPoint[0] + dy[i];
					int y = currPoint[1] + dx[i];
					if(x >= 0 && x < N && y >= 0 && y < N && !isVisited[x][y] && map[x][y] != 0) {
						isVisited[x][y] = true;
						queue.offer(new int[] {x,y});
						map[x][y] = cnt;
					}
				}
			}
		}
	}
}
