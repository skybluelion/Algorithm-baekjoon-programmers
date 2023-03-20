import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M; //  N : row행, M : col열
	static int[][] map; //입력배열
	static boolean[][] visited; //방문배열
	
	//상하좌우 탐색을 위한 방향 배열
	static int[] dx = {0,0,-1,1};//상하좌우  
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}

		BFS();
		bw.write(map[N-1][M-1]+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void BFS() {
		Queue<int[]> queue = new LinkedList<>(); //배열을 넣거나 클래스를 만들고 제너릭해도됨.
		
		queue.offer(new int[] {0,0}); // 배열 초기화
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			//De-queue
			int[] currPoint = queue.poll();
			
			//En-queue
			for(int k = 0; k < 4; k++ ) {
				int x = currPoint[0] + dy[k]; //currPoint가 배열
				int y = currPoint[1] + dx[k];  
				
				 // 유효성 검사(좌표가 범위 내에 있는지, 방문 전인지, 길인지)
				if(x>=0 && x<N && y>=0 && y<M && !visited[x][y] && map[x][y]!=0) {
					visited[x][y] = true;
					map[x][y] = map[currPoint[0]][currPoint[1]] + 1;//직전 이동거리 +1
					queue.offer(new int[] {x,y});
				}
			}
		}		
	}
}
