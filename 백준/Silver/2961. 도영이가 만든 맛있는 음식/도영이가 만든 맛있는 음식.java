import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static ArrayList<Integer> result = new ArrayList<>();
	static boolean[] isSelected;
	static int[][] taste;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(st.nextToken());
		taste = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		isSelected = new boolean[N];
		subset(0);
		bw.write(Collections.min(result)+"");

		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void subset(int cnt) throws IOException {
		if (cnt == N) {
			int sin = 1;
			int ssn = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sin *= taste[i][0];
					ssn += taste[i][1];
				}
			}
			if(sin != 1 && ssn != 0)
				result.add(Math.abs(sin-ssn));
			return;
		}
		
		//cnt번째 값을 뽑은 경우
		isSelected[cnt] = true;
		subset(cnt+1);
		
		//cnt번째 값을 안뽑는 경우
		isSelected[cnt] = false;
		subset(cnt+1);
		
	}
	
}
