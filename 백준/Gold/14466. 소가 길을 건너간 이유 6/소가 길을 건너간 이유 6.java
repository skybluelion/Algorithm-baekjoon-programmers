import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	
	static boolean check[][];
	static HashMap<Point, ArrayList<Point>> visited;
	static int N,K,R, result;
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static Point p[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		visited = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				visited.put(new Point(i,j), new ArrayList<>());
			}
		}
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			Point p1 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			Point p2 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			visited.get(p1).add(p2);
			visited.get(p2).add(p1);
		}
		p = new Point[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < K; i++) {
			check = new boolean[N + 1][N + 1];
			bfs(p[i].x, p[i].y);
			for (int j = i + 1; j < K; j++) {
				if (!check[p[j].x][p[j].y]) {
					result++;
				}
			}
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}//main
	
	private static void bfs(int x, int y) {
		Queue<Point> q=new LinkedList<Point>();
		q.add(new Point(x,y));
		check[x][y]=true;
		while(!q.isEmpty()) {
			Point next=q.remove();
			for(int i=0;i<4;i++) {
				int x1=next.x+dx[i];
				int y1=next.y+dy[i];
				Point next1 = new Point(x1,y1);
				if(x1<=0||x1>N||y1<=0||y1>N)
					continue;
				if(visited.get(next).contains(next1)||check[x1][y1])
					continue;
				check[x1][y1]=true;
				q.add(new Point(x1,y1));
			}
		}//while
	}//bfs
}//class