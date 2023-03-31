import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(st.nextToken());
		HashMap<String, String> hm = new HashMap();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			String ent = st.nextToken();
			hm.put(str,ent);
		}
		
		ArrayList<String> arr = new ArrayList();
		
		Iterator<String> keys = hm.keySet().iterator();
        while( keys.hasNext() ){
            String key = keys.next();
            if(hm.get(key).equals("enter")) arr.add(key);            
        }
		
		Collections.sort(arr);
		
		for (int i = arr.size()-1; i >= 0; i--) bw.write(arr.get(i)+"\n");

		bw.flush();
		bw.close();
		br.close();
	}
	
}