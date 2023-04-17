import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		int result = -1;
		if(N == 1 ) {
			for (int i = 2; i <= 8; i++) {
				int num  = Integer.parseInt(st.nextToken());
				if(num != i) {
					result = 0;
					break;
				}
			}
			if(result != 0) result = 2;
		}else if(N == 8) {
			for (int i = 7; i >= 1; i--) {
				int num  = Integer.parseInt(st.nextToken());
				if(num != i) {
					result = 0;
					break;
				}
			}
			if(result != 0) result = 1;
		}else result = 0;

		switch (result) {
		case 2: {
			bw.write("ascending");
			break;
		}
		case 1: {
			bw.write("descending");
			break;
		}
		default:
			bw.write("mixed");
			break;
		}
		bw.flush();
		bw.close();
		br.close();
	}
}