import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<String> arr = new ArrayList();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(st.nextToken());
		}
		
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(arr.contains(str)) cnt++;
		}
		
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}

	
}