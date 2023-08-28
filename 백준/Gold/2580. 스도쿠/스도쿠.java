import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

// 백트랙킹 문제 dfs
// 백준 15652 https://www.acmicpc.net/problem/15652


public class Main {

	static int[][] arr = new int[9][9];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sol(0,0);
		
	}
	public static void sol(int row,int col) {

		
		//열이 모두 채워졌을 경우
		if(col == 9) {
			sol(row + 1, 0);
			return;
		}
		
		// 행이 모두 채워졌을 경우
		if (row == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
 
			// 출력 뒤 시스템을 종료
			System.exit(0);
		}
 
		// 1부터 9까지 중 가능한 수 탐색
		if (arr[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				// i값 중복검사
				if (possibility(row, col, i)) {
					arr[row][col] = i;
					sol(row, col + 1);
				}
			}
			arr[row][col] = 0;
			return;
		}
 
		sol(row, col + 1);
		
	}
	
	public static boolean possibility(int row, int col, int value) {
		 

		for (int i = 0; i < 9; i++) {
			// 같은 행 검사
			if (arr[row][i] == value) return false;
			
			// 같은 열 검사
			if (arr[i][col] == value) return false;
		}

 
		// 3*3 칸 중복 검사
		int set_row = (row / 3) * 3; // value가 속한 3x3의 행의 첫 위치
		int set_col = (col / 3) * 3; // value가 속한 3x3의 열의 첫 위치
 
		for (int i = set_row; i < set_row + 3; i++) {
			for (int j = set_col; j < set_col + 3; j++) {
				if (arr[i][j] == value) {
					return false;
				}
			}
		}
 
		return true; // 중복되는 것이 없을 경우 true 반환
	}
	
}