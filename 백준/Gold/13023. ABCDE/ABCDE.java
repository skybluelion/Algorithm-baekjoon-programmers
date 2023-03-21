import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static boolean[] isVisited;
	static ArrayList<Integer>[] adjList;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList();
		}
		flag = false;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}
		for (int i = 0; i < N; i++) {
			if(flag) break;
			isVisited = new boolean[N];
			isVisited[i] = true;
			DFS(i,1);
		}
		if(flag) bw.write(1+"");
		else bw.write(0+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void DFS(int currNode,int depth) {
		if(depth==5) {
			flag = true;
			return;
		}
		for (int node : adjList[currNode]) {
			if(!isVisited[node] ) {
				isVisited[node] = true;
				DFS(node,depth+1);		
			}
		}
		isVisited[currNode] = false;
	}
}
