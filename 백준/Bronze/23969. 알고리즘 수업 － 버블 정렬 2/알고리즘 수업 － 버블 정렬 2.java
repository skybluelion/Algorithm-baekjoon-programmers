import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		int temp = 0;
		int cnt = 0;
		for(int i = 0; i < N-1; i++) {
			for(int j = 0; j < N-1; j++) {
				if(A[j] > A[j+1]) {
					temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
					cnt++;
					if(cnt == K) {
						break;
					}
				}
			}
			if(cnt == K) {
				break;
			}
		}
		
		if(cnt < K) {
			sb.append(-1);
		} else {
			for(int i = 0; i < N; i++) {
				sb.append(A[i]+" ");				
			}
		}
		
		System.out.print(sb.toString());
		
	}

}
