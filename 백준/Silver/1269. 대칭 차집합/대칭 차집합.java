import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	int A = Integer.parseInt(st.nextToken());
			map.put(A,A);
        }
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
        	int B = Integer.parseInt(st.nextToken());
        	if(map.containsKey(B)) cnt++;
        	map.put(B,B);
        }
        
        bw.write(map.size()-cnt+"");
        bw.flush();
	    bw.close();
	    br.close();
    }	
}