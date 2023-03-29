import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		HashMap<String, String> pm = new HashMap<String, String>();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			cnt++;
			pm.put(Integer.toString(cnt), str);
			pm.put(str,Integer.toString(cnt));//거꾸로도 넣어서 키값 넣기		
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String pk = st.nextToken();
			bw.write(pm.get(pk)+"\n"); 
		}
		bw.flush();
		bw.close();
		br.close();
	}
}