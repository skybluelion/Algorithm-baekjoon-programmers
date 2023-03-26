import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static long G;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long a0 = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = (long)Integer.parseInt(st.nextToken())-a0;
		}
		gcd(arr[1],arr[2]);
		
		for (int i = 2; i < arr.length; i++) {
			gcd(arr[i],G);
		}
		
		long result = arr[N-1]/G-(N-1);
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void gcd(long a, long b) {
		if(a>b) {
			long R = a%b;
			if(R == 0) {
				G = b;
				return;
			}
			gcd(b,R);
		}else {
			long R = b%a;
			if(R == 0) {
				G = a;
				return;
			}
			gcd(a,R);
		}
	}
	
}