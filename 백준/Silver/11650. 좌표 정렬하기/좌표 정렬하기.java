import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		int[][] num = new int [N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num, (o1,o2) -> {
			return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1];
		});
		
		for (int i = 0; i < N; i++) {
			bw.write(num[i][0] + " " + num[i][1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
