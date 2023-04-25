import java.io.*;

public class Main {
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			cnt = 1;
			String str = br.readLine();
			int result = isPalindrome(str);
			bw.write(result+" "+cnt+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}//main
	
	public static int recursion(String s,int l, int r) {
		if(l >= r) return 1;
		else if(s.charAt(l) != s.charAt(r)) return 0;
		else {
			cnt++;
			return recursion(s,l+1,r-1);
		}
	}
	
	public static int isPalindrome(String s) {
		return recursion(s,  0,  s.length()-1);
	}
	
}//class