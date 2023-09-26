import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] rope = new int[N];
		
		for(int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(rope);
		
		int w = 0;
		int max = 0;
		int cnt = 1;
		for(int i = N-1; i >= 0; i--) {
			w = rope[i] * cnt;
			if(w > max) {
				max = w;
			}
			cnt++;
		}
		
		System.out.println(max);
	}
}