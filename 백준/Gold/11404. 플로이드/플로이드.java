import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int n;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int [n][n];
		
		
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(arr[a-1][b-1] == 0) arr[a-1][b-1]=c;
			else if(arr[a-1][b-1] > c) arr[a-1][b-1]=c;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					floyd(i,j);
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bw.write(arr[i][j]+" ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void floyd(int x, int y) throws IOException {
		for (int i = 0; i < n; i++) {
			if(arr[x][i]!=0 && arr[i][y]!=0) {
				int m = arr[x][i]+arr[i][y];
				if(arr[x][y]>m || arr[x][y]==0) arr[x][y]=m;
			}
		}
		if(x==y) arr[x][y]=0;
		
	}
}
