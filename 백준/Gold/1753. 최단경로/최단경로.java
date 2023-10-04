import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Edge implements Comparable<Edge> {
	int to, w;
	
	public Edge(int to, int w) {
		super();
		this.to = to;
		this.w = w;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.w - o.w;
	}
	
}

public class Main {
	
	// 전역적 접근이 필요한 변수 - 인접리스트 list, 결과거리 dist
	static ArrayList<Edge> edgeList[];
	static int dist[]; 
	
	
	//다익스트라는 그래프에서 간선에 가중치가 존재할때 사용됨
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		
		edgeList = new ArrayList[V+1];
		for(int i = 1; i < edgeList.length; i++) 
			edgeList[i] = new ArrayList<Edge>();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			edgeList[from].add(new Edge(to, w));
		}
		
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		dijkstra(start);
		
		for(int i=1;i<dist.length;i++) {
			if(dist[i]== Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
		
	}
	
	public static void dijkstra(int start) {
		//PriorityQueue를 사용하면 최소값 기준으로 들어가기 때문에 연산이 줄어든다
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			Edge currPoint = pq.poll();

			for(Edge next : edgeList[currPoint.to]) {
				if(dist[next.to] > currPoint.w + next.w) {
					dist[next.to] = currPoint.w + next.w;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}			
		}
	}
}
