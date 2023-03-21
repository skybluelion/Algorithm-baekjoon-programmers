import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	

	static int[] parents;
	
	static void make(int n) {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int x) {
		if (parents[x] == x) return x;
		return find(parents[x]);
	}
	
	static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot == yRoot) return;
		parents[yRoot] = xRoot;
	}
	
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
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		make(n+1);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(A==0) union(a,b); 
            else {
				if(isSame(a,b)) bw.write("YES\n");
				else bw.write("NO\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}