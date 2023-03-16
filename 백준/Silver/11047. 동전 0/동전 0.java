import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//동전의 종류 배열
		int[] A = new int [N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//동전의 개수 배열
		int[] coin = new int [N];
		for (int i = N-1; i >= 0; i--) {
			if(K/A[i] >= 0 ) {
				coin[i]=K/A[i];
				K=K-K/A[i]*A[i];
			}
		}
		
		int sum = 0;
		for (int i : coin) {
			sum += i;
		}
		
		bw.write(sum+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
