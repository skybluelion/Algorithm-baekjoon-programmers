import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		HashMap<String,Boolean> map = new HashMap<>();
		map.put("ChongChong", true);
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name1 = st.nextToken();
			if(!map.containsKey(name1)) map.put(name1, false);
			String name2 = st.nextToken();
			if(!map.containsKey(name2)) map.put(name2, false);
			
			if((!map.get(name1) && map.get(name2))||(map.get(name1) && !map.get(name2))) {
				map.put(name1, true);
				map.put(name2, true);
				cnt++;
			}
		}
		
		
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}
}