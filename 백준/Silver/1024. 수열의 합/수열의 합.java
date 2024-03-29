import java.io.*;
import java.util.*;
 
public class Main {
    static int N,L;
    static int min=9999;
    static int start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=i; j<i+L; j++)
                sum+=j;
            
            int cnt = 0;
            
            if(sum == N) {
                for(int j=i; j<i+L; j++)
                    System.out.print(j+" ");
                return;
            }else if(sum > N) {
                break;
            }else {
                for(int j=i+L; j<N; j++) {
                    sum += j;
                    cnt++;
                    if(cnt+L>100)
                        break;
                    if(sum > N)
                        break;
                    else if(sum == N) {
                        if(cnt+L >= L && min > cnt+L) {
                            min = cnt+L;
                            start = i;
                        }
                    }
                }
            }
        }
        if(min == 9999)
            System.out.println("-1");
        else {
            for(int i=start; i<start+min; i++)
                System.out.print(i+" ");
        }
    }    
}