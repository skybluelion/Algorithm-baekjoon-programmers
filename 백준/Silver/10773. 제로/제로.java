import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) stk.pop();
			else stk.push(x);
		}
		
		long sum = 0;
		for (Integer i : stk) {
			sum += i;
		}
		bw.write(sum+"");
		bw.flush();
		bw.close();
		br.close();
	}
}//main