import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		Integer [] num = new Integer [str.length()];
		for (int i = 0; i < str.length(); i++) {
			num[i] = (int)str.charAt(i)-'0';			
		}
		Arrays.sort(num, Collections.reverseOrder());
		for (int i = 0; i < num.length; i++) {
			bw.write(num[i]+"");			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
