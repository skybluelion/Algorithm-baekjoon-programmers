import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, sum, result;
	static int[] cards, arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cards = new int[3];
		arr = new int [N];
		
		result = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		comb(0, 0);
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}
	private static void comb(int cnt, int startIndex) throws IOException {
		if(cnt == 3) {
			sum = 0;
			for (int i = 0; i < cards.length; i++) sum += cards[i];
			if(sum <= M && sum > result) result = sum;

			return;
		}
		for (int i = startIndex; i < N; i++) {
			cards[cnt] = arr[i]; 
			comb(cnt+1, i+1);
		}
	}

}