import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;
	static int N;
	static void make(int n) {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	// x 노드의 대표 노드 반환
	static int find(int x) {
		if (parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	// x U y
	static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot == yRoot) return; // x와 y가 같은 집합일 때
		parents[yRoot] = xRoot;
	
	}
	
	//x와 y노드가 같은 집합인지 확인
	static boolean isSame(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot == yRoot) return true;
		else return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		parents = new int [N+1];
		make(N+1);
		boolean flag = false;
		int[] path = new int [M];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) union(i,j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			path[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M-1; i++) {
			if(isSame(path[i],path[i+1])) flag = true;
            else {
				flag = false;
				break;
			}
		}
		
		if(flag) bw.write("YES");
		else bw.write("NO");
		
		bw.flush();
		bw.close();
		br.close();	
	}
}