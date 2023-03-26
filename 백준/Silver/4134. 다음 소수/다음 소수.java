import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long N = Long.parseLong(st.nextToken());
		
		for (long i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			
			var bi = new BigInteger(String.valueOf(A));
			
			if (bi.isProbablePrime(10)) bw.write(A+"\n"); //A가 소수면 출력
			else bw.write(bi.nextProbablePrime()+"\n");  // 소수가 아니면 다음 소수를 구해서 출력.
		
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}