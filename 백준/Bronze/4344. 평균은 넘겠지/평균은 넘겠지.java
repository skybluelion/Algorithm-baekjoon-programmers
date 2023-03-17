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
		int[] arr = null;

		for (int i = 0; i < N; i++) {
			double sum = 0;
			st = new StringTokenizer(br.readLine());
			int arrN = Integer.parseInt(st.nextToken());
			arr = new int[arrN];
			for(int j = 0; j < arrN; j++) {
				arr[j]=Integer.parseUnsignedInt(st.nextToken());
				sum += arr[j];	
			}
			double avg = sum/arrN;
			double cnt =0;
			for (int score : arr) {
				if(score > avg) cnt++;
			}
			bw.write(String.format("%.3f", cnt/arrN*100)+"%\n");
		}	
		bw.flush();
		bw.close();
		br.close();	
	}
}