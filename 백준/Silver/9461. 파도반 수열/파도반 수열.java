import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int N = 0;
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i < 101; i++){
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.print(sb);
    }
}