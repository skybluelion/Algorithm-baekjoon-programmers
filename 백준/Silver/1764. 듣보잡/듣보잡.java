import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			map.put(str, str);
		}
        
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	String str= st.nextToken();
        	if(map.containsKey(str))arr.add(str);
		}
	    
        Collections.sort(arr);
        bw.write(arr.size()+"\n");
        for (String string : arr) {
			bw.write(string+"\n");
		}
        bw.flush();
	    bw.close();
	    br.close();
    }	
}