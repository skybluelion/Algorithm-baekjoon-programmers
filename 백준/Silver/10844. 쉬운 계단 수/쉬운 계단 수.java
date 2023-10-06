import java.io.*;

public class Main {
	
	static final int mod = 1000000000;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long dp[][] = new long[101][11];		
		int n = Integer.parseInt(br.readLine());
		long result = 0;
		
		// 1 초기화
		for(int i = 1; i <= 9; i++){
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= n; i++){
			//0일때
			dp[i][0] = dp[i-1][1] % mod;
			for(int j = 1; j <= 9; j++){
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
			}
		}
		
		for(int i = 0; i <= 9; i++) {
			result = (result + dp[n][i]) % mod;        	
		}
		
		System.out.println(result);
		
		br.close();		
	}
}