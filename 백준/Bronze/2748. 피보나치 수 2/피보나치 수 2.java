import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write( dp(n) + "");
        bw.flush();
        bw.close();
    }

    public static long dp(int n){
        long[] dp = new long[91];

        dp[0] = 0;
        dp[1] = 1;

        if(n == 1){
            return dp[1];
        }else{
            for(int i = 2; i <= n; i++){
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];
    }

}
