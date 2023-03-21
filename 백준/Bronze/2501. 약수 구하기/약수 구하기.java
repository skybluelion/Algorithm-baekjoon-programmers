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
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr = new ArrayList();
		for (int i = 1; i <= N; i++) {
			if(N%i == 0) arr.add(i);
		}
		if(arr.size() >= k) bw.write(arr.get(k-1) + "");
		else bw.write(0+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
}
