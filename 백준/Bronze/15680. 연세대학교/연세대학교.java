import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String N = br.readLine();
		
		if(N.equals("0")) bw.write("YONSEI");
		else bw.write("Leading the Way to the Future");
		
		bw.flush();
		bw.close();
		br.close();
	}
}