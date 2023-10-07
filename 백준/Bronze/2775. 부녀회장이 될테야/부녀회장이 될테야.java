import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[15][15];
		for(int i = 1; i <= 14; i++) {
			dp[i][1] = 1;
			dp[0][i] = i;
		}
		
		for(int i = 1; i <= 14; i++) {
			for(int j = 1; j <= 14; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i -1][j];
			}
		}
		
		
		for(int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[k][n]);
		}

		br.close();		
	}
}