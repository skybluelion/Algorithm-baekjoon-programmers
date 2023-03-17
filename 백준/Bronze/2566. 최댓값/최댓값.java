import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
	
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = 9;
		int[][] arr = new int[N][N];
		int max=0;
		int maxX = 0, maxY = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]>=max) {
					max = arr[i][j];
					maxX = i+1; maxY = j+1;
				}
			}
		}
		bw.write(max + "\n" + maxX + " " + maxY);
		bw.flush();
		bw.close();
		br.close();	
	}

}