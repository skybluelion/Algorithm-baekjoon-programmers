import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
	int from, to, weight;

	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
}

public class Main {
	
	static int V, E; //정점 개수, 간선 개수
	static Edge[] edgeList; //간선리스트
	
	//유니온 파인드
	static int[] parents;
	
	//크기가 1인 서로소 집합
	static void make() {
		parents = new int[V+1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	//대표 노드 반환
	static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	// x U y
	static boolean union(int x, int y) {
		int xRoot = find(x); // x노드의 대표 노드
		int yRoot = find(y); // y노드의 대표 노드
		if(xRoot == yRoot) return false; // 대표노드가 같을 때 
		parents[yRoot] = xRoot; //대표노드를 합침
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		
		// weight를 기준으로 edgeList 정렬
		Arrays.sort(edgeList, (e1, e2) -> e1.weight - e2.weight); // (비교대상) -> 기준
																  // 기준을 쓸 때 -를 쓰는 것은 양수면 왼쪽이 큰것
																  //		0이면 둘이 동일  음수면 왼쪽이 작은것
		make();
		
		int edgeCnt = 0;
		int totalWeight = 0;
		
		for (Edge e : edgeList) {
			if(union(e.from,e.to)) {
				edgeCnt++;               // 연결될 때 마다
				totalWeight += e.weight; 
				if(edgeCnt == V - 1) break; // 최소 스패닝에서 간선의 개수
			}
		}
		
		bw.write(totalWeight+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
