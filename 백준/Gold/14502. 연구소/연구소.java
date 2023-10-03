import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[][] map;
	static int[][] newMap;
    static int[] dx = {-1, +1,  0,  0};
    static int[] dy = { 0,  0, -1, +1};
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		System.out.println(dfs(0));
		
	}
    // 벽세우기 - 완전탐색 백트래킹 dfs
    public static int dfs(int wall) {
        if (wall == 3) {
            bfs();
            return max;
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
        return max;
    }

    // 바이러스 bfs
    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        newMap = new int[N][M];

        // 벽이 세개 세워질 때마다 bfs를 실행해야하므로
        // 현재 벽이 세워진 map을 복사해서 써야함 - 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
                if (newMap[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] currPoint = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = currPoint[0] + dx[i];
                int y = currPoint[1] + dy[i];

                if (x >= 0 && x < N && y >= 0 && y < M && newMap[x][y] == 0) {
                    newMap[x][y] = 2;
                    queue.add(new int[]{x, y});
                }
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newMap[i][j] == 0) {
                    cnt++;
                }
            }
        }

        max = Math.max(max, cnt);
    }
}