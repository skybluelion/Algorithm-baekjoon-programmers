import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		int sum = 1;
		for (int i = 1; i <= N; i++) {
			sum *= 2; 
		}
		bw.write(sum+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
