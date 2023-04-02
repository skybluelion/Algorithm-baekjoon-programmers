import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	

		int N = Integer.parseInt(br.readLine());
		
		int cnt = 1;
		int result = 1;
		
		while(result < N) {
			result += cnt*6; 
			cnt++;
		}
		
		bw.write(cnt+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
}