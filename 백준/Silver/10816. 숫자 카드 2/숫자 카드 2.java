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
        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());

	    for (int i = 0; i < N; i++) {
	        int card = Integer.parseInt(st.nextToken());
	        if(map.containsKey(card)) map.put(card, map.get(card)+1);
	        else map.put(card, 1);
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    int M = Integer.parseInt(st.nextToken());
	    st = new StringTokenizer(br.readLine());
	    
	    for (int i = 0; i < M; i++) {
	    	int su = Integer.parseInt(st.nextToken());
	    	if(map.get(su) == null) bw.write("0 ");
	    	else bw.write(map.get(su)+" ");
	    }
    
	    bw.flush();
	    bw.close();
	    br.close();
    }	
}