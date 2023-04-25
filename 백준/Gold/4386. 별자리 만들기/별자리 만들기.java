import java.io.*;
import java.util.*;

class Star {
	double x, y;
	int num;
	
	public Star(double x, double y,int num) {
		super();
		this.x = x;
		this.y = y;
		this.num = num;//별의 순서
	}
}//Star

class Edge implements Comparable<Edge> {
	int from, to;
	double weight;
	
	public Edge(int from, int to, double weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	//비용기준 오름차순
	@Override
	public int compareTo(Edge o) {
		if (weight < o.weight) return -1;
		return 1;
	}
}//Edge

public class Main {

	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		Star[] s = new Star[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			s[i] = new Star(x, y, i);
		}
		
		// 별 간선과 비용에 대한 간선리스트 edgeList
		ArrayList<Edge> edgeList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				double weight = Math.sqrt(Math.pow(s[i].x - s[j].x, 2) + Math.pow(s[i].y - s[j].y, 2));
				edgeList.add(new Edge(s[i].num, s[j].num, weight));//i번째 별부터 j번째 별까지의 비용 간선리스트
			}
		}
		
		Collections.sort(edgeList);

		//대표노드=자신 초기화
		parents = new int[N];
		for (int i = 0; i < N; i++) parents[i] = i;

		double totalWeight = 0;
		for (Edge e : edgeList) {
			if (union(e.from,e.to)) totalWeight += e.weight; // 연결될 때 마다
		}

		bw.write(Math.round(totalWeight*100)/100.0 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}//main
	
	//대표 노드 반환
	static int find(int x) {
		if (parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}//find

	// x U y
	static boolean union(int x, int y) {
		int xRoot = find(x); // x노드의 대표 노드
		int yRoot = find(y); // y노드의 대표 노드
		if(xRoot == yRoot) return false; // 대표노드가 같을 때 
		parents[yRoot] = xRoot; //대표노드를 합침
		return true;
	}//union

}//class