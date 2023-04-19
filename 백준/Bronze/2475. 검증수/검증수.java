import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			int N = Integer.parseInt(st.nextToken());
			sum += Math.pow(N, 2);
		}
		
		bw.write(sum%10+"");
		bw.flush();
		bw.close();
		br.close();
	}
}