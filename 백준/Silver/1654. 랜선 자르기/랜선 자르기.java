import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    
    static long count;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        int[] lan = new int[k];
        for(int i=0; i<k; i++){
            lan[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(lan);
        long rt = lan[k-1];
        long lt = 1;
        long mid=(lt+rt)/2;
        while((rt - lt) >1){
            count = countLans(mid, k, lan);
            if(count >= n){	
                lt= mid;
                mid = ((rt-lt)/2)+lt;
            } else {
                rt =mid-1;
                mid = ((rt-lt)/2)+lt;
            }
        }
        
        count = countLans(rt, k, lan);     
        if(count >= n){
            System.out.println(rt);   
        } else {
            System.out.println(lt);
        }        

    }
    
    public static long countLans(long mid, long k, int[] lan){
        count = 0;
        for(int i=0; i<k; i++){
            count += lan[i]/mid;
        }
        return count;
    }
}