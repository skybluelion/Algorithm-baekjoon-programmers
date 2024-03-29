import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(K==0) bw.write(1+"");
		else {
			int Nfac = factorial(N);
			int Kfac = factorial(K);
			int fac = factorial(N-K);
			
			bw.write(Nfac/Kfac/fac+"");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static int factorial(int x) {
		int result=1;
		if(x>0)	for (int i = 1; i <= x; i++) result *=i;
		return result;
	}
}