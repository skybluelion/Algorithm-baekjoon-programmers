import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		bw.write(fibo(N)+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	public static int fibo(int n) {
		if(n==0) return 0;
		else if(n==1) return 1;
		else {
			n = fibo(n-1)+fibo(n-2);			
			return n;
		}
	}
}