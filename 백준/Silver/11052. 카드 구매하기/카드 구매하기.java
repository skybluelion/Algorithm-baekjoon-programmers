import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] P = new int[N + 1];
        for(int i = 1; i <= N; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        dp[0] = 0;
        dp[1] = P[1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i], dp[i - j] + P[j]);
            }
        }

        bw.write(dp[N] + "");
        bw.flush();
        bw.close();
    }

}