import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = 5;
		int M = 15;
		int max = 0;
		String word = null;
		char[][] str = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			word = br.readLine();
			max = Math.max(max, word.length());
			for (int j = 0; j < word.length(); j++) {
				str[i][j] = word.charAt(j);
			}
		}		
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < N; j++) {
				if(str[j][i] == '\0') continue;
				else bw.write(str[j][i]);
			}
		}
		bw.flush();
		bw.close();
		br.close();	
	}
}
