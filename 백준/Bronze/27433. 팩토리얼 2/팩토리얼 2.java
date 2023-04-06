import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		int N = Integer.parseInt(br.readLine());
		long result = 1;
		if(N == 0) bw.write(result+"");
		else {
			for (int i = 1; i <= N; i++) result *= i;
			bw.write(result+"");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}