import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static int N;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[1000001];
		
		gop(N);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void gop(int x) throws IOException{
		for (int i = 0; i < 5; i++) arr[i]=i;
		int k = N/3;
		int m = N%3;
		int result = 1;
		
		if(x<5) bw.write(arr[x]+""); // 5 아래는 그대로
		else {
			if(m == 1) { // 4를 곱해야 하는 경우
				k-=1;
				result=4;
			} else if(m == 2) result = 2; // 2를 곱해야 하는 경우
		
			for (int i = 0; i < k; i++) { //3을 k번 곱하고 10007로 나누기
				result = (result*3)%10007;
			}
			bw.write(result+"");
		}
	}
}