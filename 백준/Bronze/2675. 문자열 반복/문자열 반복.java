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
		
		//테스트 케이스
		int T = Integer.parseInt(st.nextToken());
		//반복 횟수
		int R;
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			String[] arr = S.split("");
			
			//R만큼 출력
			for (int j = 0; j < arr.length; j++) {
				for(int k = 0; k < R; k++) {
					bw.write(arr[j]+"");					
				}
			}
			bw.write("\n");
		}
		

	
		bw.flush();
		bw.close();
		br.close();
	}
}