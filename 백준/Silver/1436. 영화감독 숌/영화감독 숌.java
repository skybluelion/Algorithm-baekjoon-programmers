import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer,Integer> map = new HashMap<>();
		int key = 1;
		int value = 666;
		while(key<=N) {
			if(String.valueOf(value).contains("666")) map.put(key++,value);
			value++;
		}

		bw.write(map.get(N)+"");
		bw.flush();
		bw.close();
		br.close();
	}
}