import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] adjList ;
	static int N, M;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N+1];
		visited = new boolean[N+1];
		int cnt = 0;
		for (int i = 0; i < N+1; i++) {
			adjList[i] = new ArrayList();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}

		
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				DFS(i);	
				cnt++;
			}
		}
		
		bw.write(cnt+"");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static void DFS(int currNode) {
		for (int node : adjList[currNode]) {
			if(!visited[node]) {
				visited[node] = true;
				DFS(node);
			}
		}

	}

}
