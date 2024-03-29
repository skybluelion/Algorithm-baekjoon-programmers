import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		int fac = 1;
		if(N>=1) for (int i = 1; i <= N; i++) fac *= i; 
		
		bw.write(fac+"");
		bw.flush();
		bw.close();
		br.close();
	}
}