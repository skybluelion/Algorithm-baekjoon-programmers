import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백트랙킹 문제 dfs
// 백준 15652 https://www.acmicpc.net/problem/15652


public class Main {

	static int N,M;
	static StringBuilder sb = new StringBuilder();
	static int[] temp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		

		temp = new int[M];
		
		dfs(1,0);
		bw.write(sb+"");
		bw.flush();
		bw.close();
	}
	
	private static void dfs(int step,int depth) {
		if(depth == M) {
			for(int i : temp) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = step; i <= N; i++) {
			temp[depth] = i;
			dfs(i ,depth + 1);
		}
	}
}