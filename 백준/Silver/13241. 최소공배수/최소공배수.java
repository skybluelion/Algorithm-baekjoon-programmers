import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	

		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		
		gcd(A,B);
		
		long result = (A * (B / X));
		
		String s = String.valueOf(result);
		bw.write(s);

		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void gcd(long a, long b) {
		if(a>b) {
			long R = a%b;
			if(R == 0) {
				X = b;
				return;
			}
			gcd(b,R);
		}else {
			long R = b%a;
			if(R == 0) {
				X = a;
				return;
			}
			gcd(a,R);
		}
	}
}