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
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = M; i <= N; i++) {
			var primeNum = new BigInteger(String.valueOf(i));
			if (primeNum.isProbablePrime(10)) bw.write(primeNum+"\n"); //primeNum가 소수면 출력
			else continue;
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}