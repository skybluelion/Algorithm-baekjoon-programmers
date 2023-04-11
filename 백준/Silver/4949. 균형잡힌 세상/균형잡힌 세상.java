import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str=null;
		while(true) {
			str = br.readLine();
			if(str.equals(".")) break;
			sb.append(stackPop(str)).append("\n");
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
			if(c == '(' || c == '[') stk.push(c);
			else if(c == ')') {
				if(stk.empty() || stk.peek() != '(') return "no";
				else stk.pop();
			}else if(c == ']') {
				if(stk.empty() || stk.peek() != '[') return "no";
				else stk.pop();
			}
		}
		if (stk.empty()) return "yes"; 
		else return "no";
	}
}