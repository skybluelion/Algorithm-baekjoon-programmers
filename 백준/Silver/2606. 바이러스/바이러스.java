import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int cnt = 0;
	static int adjMatrix[][];
	static boolean isVisited[];
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		adjMatrix = new int[N+1][N+1];
		isVisited = new boolean[N+1];
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}
		isVisited[1] = true;
		
		System.out.println(dfs(1));
	}
	
	public static int dfs(int curr) {
		
		for(int i = 1; i <= N; i++) {
			if(adjMatrix[curr][i] == 1 && !isVisited[i]) {
				isVisited[i] = true;
				cnt++;
				dfs(i);
			}
			
		}
		
		return cnt;
	}
	
}