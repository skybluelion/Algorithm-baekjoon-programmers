import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] adjMatrix;
	static int N, M;
	static boolean[] isVisited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		adjMatrix = new int[N+1][N+1];
		isVisited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;	
		}
		isVisited[V] = true;
		dfs(V);
		sb.append("\n");
		
		isVisited = new boolean[N+1];
		isVisited[V] = true;
		bfs(V);
		System.out.println(sb.toString());
	}
	
	public static void dfs(int curr) throws IOException {
		sb.append(curr + " ");
		
		for(int i = 1; i <= N; i++) {
			if(adjMatrix[curr][i] != 0 && !isVisited[i]) {
				isVisited[i] = true;
				dfs(i);
			}
		}
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(start);

		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr + " ");
			
			for(int i = 1; i <= N; i++) {
				if(adjMatrix[curr][i] != 0 && !isVisited[i]) {
					isVisited[i] = true;
					queue.offer(i);
				}
			}
		}
	}
}
