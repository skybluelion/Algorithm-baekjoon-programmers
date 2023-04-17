import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<Character> arr = new ArrayList<>();
		while(true) {
			boolean flag = true;
			String str = br.readLine();
			if(str.equals("0")) break;
			for (int i = 0; i < str.length(); i++) {
				arr.add(i, str.charAt(i));
			}
			for (int i = 0; i < str.length()/2; i++) {
				if(!arr.get(i).equals(arr.get(str.length()-1-i))) {
					flag = false;
					break;
				}
				flag = true;
			}
			if(flag) bw.write("yes\n");
			else bw.write("no\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}