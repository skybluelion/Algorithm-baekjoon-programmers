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
			
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int N =  Integer.parseInt(st.nextToken());
		int sum =0;
		ArrayList<Integer> arr = new ArrayList();
		for (int i = M; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= i; j++) {
				if(i%j == 0) cnt++;
			}
			if(cnt == 2) {
				arr.add(i);
				sum += i;
			}
		}
		if(arr.size() == 0) bw.write(-1+"");
		else bw.write(sum+"\n"+arr.get(0));
		bw.flush();
		bw.close();
		br.close();
	}
}