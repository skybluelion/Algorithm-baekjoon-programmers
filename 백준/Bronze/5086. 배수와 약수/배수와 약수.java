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
		
		int N = 10000;
		int M = 10000;
		while(N != 0 && M !=0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N > M && N % M == 0) bw.write("multiple\n");
			else if(M > N && M % N == 0) bw.write("factor\n");
			else if(N == 0 && M == 0) break;
			else bw.write("neither\n");	
		}
		bw.flush();
		bw.close();
		br.close();
	}
}