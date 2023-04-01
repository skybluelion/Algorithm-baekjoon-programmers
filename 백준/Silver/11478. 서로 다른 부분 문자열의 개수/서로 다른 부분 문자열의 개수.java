import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		HashMap<String,String> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i+1; j <= str.length(); j++) {
				map.put(str.substring(i, j), str.substring(i, j));
			}
		}
		bw.write(map.size()+"");
		bw.flush();
		bw.close();
		br.close();
	}
}