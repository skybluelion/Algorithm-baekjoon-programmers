import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String s = br.readLine();
			if(s.equals(".")) break;
			bw.write(kmp(s)+"\n");
		}
			
		
		bw.flush();
		bw.close();
		br.close();
	}//main
	private static int kmp(String s) {
		int leng = s.length();
		int[] arr = new int[leng];
		int index = 0;

		for(int i = 1; i < leng; i++) {
			while(index>0 && s.charAt(i) != s.charAt(index)) {
				index = arr[index-1];
			}
			if(s.charAt(i) == s.charAt(index)) {
				arr[i] = ++index;
			}
		}
		return leng % (leng - arr[leng - 1]) != 0 ? 1 : leng / (leng - arr[leng - 1]);
	}//kmp
}//class
