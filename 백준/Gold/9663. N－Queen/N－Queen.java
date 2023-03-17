import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N,cnt ;
	static int[] columns = new int[N];  

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		columns = new int[N];// index번째 줄에 배치할 퀸의 위치

		setRowQueen(0); 
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}
	private static void setRowQueen(int line) {  //cnt번째 줄에 퀸배치
		//기저조건
		if(line ==N) {
			cnt++;
			return;
		}
		
		
		for (int i = 0; i < N; i++) {
			columns[line]=i;		//cnt번째 줄에 i번째 위치에 퀸 배치 // 현재line까지 가능한지 판단(백트랙킹)
			if(isAvailable(line)) setRowQueen(line+1); //다음줄에 퀸 배치
		}
		

	}
	
	private static boolean isAvailable(int line) { // line 번째 놓여진 Queen의 타당성 판단 
		// 같은 열에 있거나 대각선상에 있다면 불가능
		for (int i = 0; i < line; i++) {
			if(columns[line] == columns[i] || 
					(line-i) == Math.abs(columns[line] -columns[i]))
			return false;
		}
		return true;
	}
}
