import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int X = A*B*C;
		String[] str = String.valueOf(X).split("");
		int[] arr = new int[10];
		for (int i = 0; i < str.length; i++) arr[Integer.parseInt(str[i])]++;
		for (int i : arr) bw.write(i+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}