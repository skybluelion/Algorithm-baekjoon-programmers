import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m;
        int cnt, a, b, vot;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            cnt = 1;
            int work[] = new int[m + 1];
            for(int j = 0; j < m; j++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                work[a] = b;
            }

            vot = work[1];

            for(int j = 2; j <= m; j++){
                if(work[j] < vot){
                    vot = work[j];
                    cnt++;
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.print(sb);
    }
}