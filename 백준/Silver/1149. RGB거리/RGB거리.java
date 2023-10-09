import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	final static int red = 0;
	final static int green = 1;
	final static int blue = 2;
	
	static int[][] Cost;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Cost = new int[N][3];
		dp = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Cost[i][red] = Integer.parseInt(st.nextToken());
			Cost[i][green] = Integer.parseInt(st.nextToken());
			Cost[i][blue] = Integer.parseInt(st.nextToken());
		}
		
		// DP의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화
		dp[0][red] = Cost[0][red];
		dp[0][green] = Cost[0][green];
		dp[0][blue] = Cost[0][blue];
		br.close();
		int answer = Math.min(Paint_cost(N- 1, red), Math.min(Paint_cost(N - 1, green), Paint_cost(N - 1, blue)));
		System.out.println(answer);
	}
	
	public static int Paint_cost(int N, int color) {
		
		// 만약 탐색하지 않은 배열이라면
		if(dp[N][color] == 0) {
			
			// color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 DP에 저장한다
			if(color == red) {
				dp[N][red] = Math.min(Paint_cost(N - 1, green), Paint_cost(N - 1, blue)) + Cost[N][red];
			}
			else if(color == green) {
				dp[N][green] = Math.min(Paint_cost(N - 1, red), Paint_cost(N - 1, blue)) + Cost[N][green];
			}
			else {
				dp[N][blue] = Math.min(Paint_cost(N - 1, red), Paint_cost(N - 1, green)) + Cost[N][blue];
			}
			
		}
		
		return dp[N][color];
	}
}