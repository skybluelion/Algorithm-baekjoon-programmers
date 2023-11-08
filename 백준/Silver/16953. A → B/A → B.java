import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while (true){
            if(A == B){
                System.out.println(cnt+1);
                return;
            } else if(A > B || B <= 1){
                System.out.println(-1);
                return;
            }
            String strB = String.valueOf(B);

            if(B % 2 != 0 && strB.charAt(strB.length() - 1) != '1'){
                System.out.println(-1);
                return;
            }

            if(strB.charAt(strB.length() - 1) == '1' && B > 1){
                B = Integer.parseInt(strB.substring(0,strB.length()-1));
                cnt++;
            } else if(B % 2 == 0){
                B = B / 2;
                cnt++;
            }

        }

    }


}