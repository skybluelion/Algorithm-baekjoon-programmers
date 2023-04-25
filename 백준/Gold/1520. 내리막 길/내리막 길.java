import java.io.*;
import java.util.StringTokenizer;

public class Main {

	
		static int M,N;
		static int[][] map;
		static boolean[][] visited;
		static int[] dx = { -1, 1, 0, 0 };
		static int[] dy = { 0, 0, -1, 1 };
		static int[][] memo;
		static int cnt;
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			memo = new int[M][N];
			visited = new boolean[M][N];
			cnt = 0;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			bw.write(dfs(0,0)+"");
			bw.flush();
			bw.close();
			br.close();
		}
		
		public static int dfs(int r, int c) {
			cnt++;
			if (r == M-1 && c == N-1) return 1;
			if (memo[r][c] != 0) return memo[r][c];
			if(!visited[r][c]) {
				visited[r][c] = true;
				for (int i = 0; i < 4; i++) {
					int nr = r + dx[i];
					int nc = c + dy[i];
					if (nr < 0 || nc < 0 || nr >= M || nc >= N)	continue;
					if (map[nr][nc] < map[r][c]) memo[r][c] += dfs(nr, nc);
				}
			}
			return memo[r][c];
		}
}