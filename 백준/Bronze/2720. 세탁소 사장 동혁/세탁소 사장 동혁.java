import java.io.*;
import java.util.*;

public class Main {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
	    
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int money = Integer.parseInt(st.nextToken());
			exchange(money);
			bw.write("\n");
		}
        
        bw.flush();
        bw.close();
        br.close();
    }
	
	public static void exchange(int x) throws IOException {
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(1, x/25);
		x %= 25;
		map.put(2, x/10);
		x %= 10;
		map.put(3, x/5);
		x %= 5;
		map.put(4, x/1);
		for (int i = 1; i <= 4; i++) {
			bw.write(map.get(i)+" ");			
		}
	}
}