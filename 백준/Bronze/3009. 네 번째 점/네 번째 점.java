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
		
		int[] arrX = new int[1001];
		int[] arrY = new int[1001];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			arrX[Integer.parseInt(st.nextToken())]++;
			arrY[Integer.parseInt(st.nextToken())]++;
		}
		int x = 0, y= 0;
		int cnt = 0;
		for (int i = 1; i <= 1000; i++) {
			if(arrX[i]==1) x=i;
			if(arrY[i]==1) y=i;
		}
		bw.write(x + " " + y);		
		bw.flush();
		bw.close();
		br.close();
	}
}