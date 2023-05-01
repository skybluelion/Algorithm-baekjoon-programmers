import java.io.*;

public class Main {


	static StringBuilder sb; 
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = br.readLine()) != null) {
			n = Integer.parseInt(str);
			sb =new StringBuilder();
			int len = (int) Math.pow(3, n);
			for (int i = 0; i < len; i++) {
				sb.append("-");
			}
			solve(0, len);
			System.out.println(sb);
		}
	}

	public static void solve(int start,int leng) {
		if(leng==1) return;
		else {
			int newSize=leng/3;
			for(int i=start+newSize; i<start+2*newSize; i++) {
				sb.setCharAt(i, ' ');
			}
			solve(start, newSize);
			solve(start+2*newSize, newSize);
		}
	}

}