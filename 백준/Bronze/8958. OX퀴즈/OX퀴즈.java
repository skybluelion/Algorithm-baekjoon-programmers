import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int sum = 0;
			int cnt = 0;
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j)=='O') {
					cnt++;
					sum += cnt;
				} else cnt = 0;
			}
			bw.write(sum+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}