import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		int N = 1;
		while(N != -1) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == -1) break;
			int sum = 0;
			for (int i = 1; i < N; i++) {
				if(N % i == 0) sum += i;
			}
			if(N == sum) {
				bw.write(N+" =");
				int cnt = 0;
				for (int i = 1; i < N ; i++) {
					if(N % i == 0) {
						if(cnt != 0) bw.write("+");
						bw.write(" "+i+" ");
						cnt++;
					}
				}
				bw.write("\n");
			} else bw.write(N + " is NOT perfect.\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}