import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int [N+1];
		arr[0] = 4;
		int cnt = 0;
		int num = 2;
		
		for(int i = 1; i < arr.length; i++) {
			arr[i] = (int)Math.sqrt(arr[i-1]) + (int)Math.pow(num, cnt);
			arr[i] = (int)Math.pow(arr[i], 2);
			cnt++;
		}
		bw.write(arr[N]+"");
		bw.flush();
		bw.close();
		br.close();
	}
}