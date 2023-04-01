import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		List<Character> arr = new ArrayList<>();
		
		while(N!=0) {
			if(N % B < 10) arr.add((char)(N % B + '0'));
			else arr.add((char)(N % B - 10 +'A'));
			N /= B;
		}
		for (int i = arr.size()-1; i >=0 ; i--) bw.write(arr.get(i));
		bw.flush();
		bw.close();
		br.close();
	}
}