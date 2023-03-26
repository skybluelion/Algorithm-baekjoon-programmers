import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] isPrime = new boolean[246913];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean flag = false;
		getPrime();
		while(!flag) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N==0) {
				flag = true;
				break;
			}
			int cnt = 0;
			for (int i = N + 1; i <= 2 * N; i++) {
				if(!isPrime[i]) cnt++;
			}
			bw.write(cnt+"\n");	
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void getPrime() {
		isPrime[0] = isPrime[1] = true;
		
		for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
			for (int j = i * i; j < isPrime.length; j += i) {
				isPrime[j] = true;
			}
		}
	}
}