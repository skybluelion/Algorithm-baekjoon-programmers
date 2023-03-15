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
		
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N-1; j++) bw.write(" ");
			for (int j = 0; j < i*2+1; j++) bw.write("*");
			bw.write("\n");
		}
		for (int i = 0; i < N-1; i++) {
			for (int j = i; j >= 0; j--) bw.write(" ");
			for (int j = i*2+1; j < 2*(N-1); j++) bw.write("*");
			bw.write("\n");
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
