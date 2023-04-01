import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String num = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		int idx = num.length();
		int su = 0 ;
		for (int i = 0; i < num.length(); i++) {
			idx--;
			if(num.charAt(i)-'0'<10) su += Math.pow(B,idx)*(num.charAt(i)-'0');
			else su += Math.pow(B,idx)*(num.charAt(i)-'A'+10);
		}
		bw.write(su+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
}