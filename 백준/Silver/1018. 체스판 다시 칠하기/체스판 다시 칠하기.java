import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		String[] brd = new String[row];
		int sol = Integer.MAX_VALUE; // 최대값을 알 수 없기에 필드 최대값 설정
		
		for (int i = 0; i < row ; i++) {
			brd[i] = br.readLine(); // 보드를 한 줄씩 읽어서 비교
		}
		
		
		for(int i=0; i <= row - 8; i++) { // 8칸씩 묶이므로 8을 빼줌
			for(int j=0; j <= col - 8; j++) {
				int curSol = solved(i, j, brd); // 현재 값을 설정

				if(sol > curSol) { // 최소 값과 비교
					sol = curSol;
				}
			}
		}
		
		bw.write(sol+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int solved(int start_row, int start_col, String[] brd) {
		String nowBrd[] = {"WBWBWBWB", "BWBWBWBW"}; //완성시켜야하는 체스판
		int whiteSol = 0; // 다를 때 카운트
		
		for (int i = 0; i < 8; i++) {
			int row = start_row + i;
			for (int j = 0; j < 8; j++) {
				int col = start_col + j;
				
				if(brd[row].charAt(col) != nowBrd[row % 2].charAt(j)) {
					whiteSol++;
				}
			}
		}
		return Math.min(whiteSol,  64 - whiteSol); // 반대인 경우는 합쳐서 8*8
	}

}