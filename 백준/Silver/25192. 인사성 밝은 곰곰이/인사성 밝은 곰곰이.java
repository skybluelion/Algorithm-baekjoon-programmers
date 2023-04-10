import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		HashMap<String,Integer> map = new HashMap<>();
		boolean[] arr = new boolean[N];
		int cnt = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("ENTER")) {
				arr = new boolean[N];
			} else {
				if(map.containsKey(str)) {
					if(!arr[map.get(str)]) {
					arr[map.get(str)]=true;
					cnt++;
					}
				} else {
					map.put(str, idx);
					arr[map.get(str)]=true;
					idx++;
					cnt++;
				}
			}
		}
		
		bw.write(cnt+"");
		
		bw.write("");
		bw.flush();
		bw.close();
		br.close();
	}
}