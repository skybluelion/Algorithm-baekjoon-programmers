import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int GCD;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			gcd(A,B);
			int result = B*(A/GCD);
			bw.write(result+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void gcd(int a, int b) {
		if(b>=a) {
			int R = b%a;
			if(R == 0) {
				GCD = a;
				return;
			}
			gcd(R,a);
		} else {
			int R = a%b;
			if(R == 0) {
				GCD = b;
				return;
			}
			gcd(R,b);
		}
	}
}