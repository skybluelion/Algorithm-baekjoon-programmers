import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N;
	static int[][] map;
	static boolean[][] isVisited;
	static int[] dx = { 0,  0, -1, +1};
	static int[] dy = {-1, +1,  0,  0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			isVisited = new boolean[N][M];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[Y][X] = 1;
			}
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1 && !isVisited[i][j]) {
						bfs(i,j);	
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		br.close();
	}
	
	public static void bfs(int startY, int startX) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {startY, startX});
		isVisited[startY][startX] = true;
		
		while(!queue.isEmpty()) {
			int[] currPoint = queue.poll();
			for(int i = 0; i < 4; i++) {
				int x = currPoint[1] + dx[i];
				int y = currPoint[0] + dy[i];
				if(y >= 0 && y < N && x >= 0 && x < M && !isVisited[y][x] && map[y][x] != 0) {
					isVisited[y][x] = true;
					queue.offer(new int[] {y,x});
				}
			}
		}
	
	}
}
