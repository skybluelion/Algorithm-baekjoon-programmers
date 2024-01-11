import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;
    static String[] arr1, arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();

        arr1 = str1.split("");
        arr2 = str2.split("");

        dp = new int[str1.length() + 1][str2.length() + 1];

        for(int i = 0; i < str1.length() + 1; i++){
            for(int j = 0; j < str2.length() + 1; j++){
                dp[i][j] = -1;
            }
        }
        int answer = lcs(str1.length() - 1, str2.length() - 1);

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    public static int lcs(int a, int b) {
        if(a < 0 || b < 0) return 0;

        if(dp[a][b] == -1) {
            dp[a][b] = 0;
            if(arr1[a].equals(arr2[b])) dp[a][b] = lcs(a - 1, b - 1) + 1;
            else dp[a][b] = Math.max(lcs(a - 1, b), lcs(a, b - 1));
        }

        return dp[a][b];
    }

}
