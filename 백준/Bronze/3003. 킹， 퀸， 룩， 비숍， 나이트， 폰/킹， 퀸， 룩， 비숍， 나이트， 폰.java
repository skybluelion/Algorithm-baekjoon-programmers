import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N= 6;  
		int[] set = {1,1,2,2,2,8}; 
		int su;
		for (int i = 0; i < N; i++) {
			su = set[i] - Integer.parseInt(st.nextToken());
			bw.write(su + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
