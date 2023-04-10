import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		int min = 1000000;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int nextNum = Integer.parseInt(st.nextToken());
			if(nextNum>max) max = nextNum;
			if(nextNum<min) min = nextNum;
		}
		bw.write(min*max+"");
		bw.flush();
		bw.close();
		br.close();
	}
}