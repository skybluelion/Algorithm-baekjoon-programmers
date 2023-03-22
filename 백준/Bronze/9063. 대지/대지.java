import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arrX = new ArrayList();
		ArrayList<Integer> arrY = new ArrayList();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arrX.add(Integer.parseInt(st.nextToken()));
			arrY.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arrX);
		Collections.sort(arrY);
		
		int result = (arrX.get(N-1)-arrX.get(0)) * (arrY.get(N-1)-arrY.get(0));
		
		bw.write(result+"");		
		bw.flush();
		bw.close();
		br.close();
	}
}