import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			sb.append(stackPop(br.readLine())).append("\n");
		}
		
		bw.write(sb+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static String stackPop(String str) {
		Stack<Character> stk = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (c == '(') stk.push(c);
			else if (stk.empty()) return "NO"; // 스택이 비어 있는 상태에서 )가 입력된 경우
			else stk.pop();
		}
 
		if (stk.empty()) return "YES"; 
		else return "NO";
	}
}//main