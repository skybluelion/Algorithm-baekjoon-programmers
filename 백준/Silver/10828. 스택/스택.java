import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push")) stk.push(Integer.parseInt(st.nextToken()));
			else if(str.equals("pop")) {
				if(stk.isEmpty()) bw.write(-1+"\n");
				else bw.write(stk.pop()+"\n");
			} else if(str.equals("size")) bw.write(stk.size()+"\n");
			else if(str.equals("empty")) {
				if(stk.isEmpty()) bw.write(1+"\n");
				else bw.write(0+"\n");
			} else {
				if(stk.isEmpty()) bw.write(-1+"\n");
				else bw.write(stk.peek()+"\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}//main