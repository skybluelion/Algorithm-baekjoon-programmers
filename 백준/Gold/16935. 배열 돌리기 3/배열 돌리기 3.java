import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, R;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < R; i++) {
			int type = Integer.parseInt(st.nextToken());
			if(type == 1) one();
			else if(type == 2) two();
			else if(type == 3) three();
			else if(type == 4) four();
			else if(type == 5) five();
			else if(type == 6) six();
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void one() {
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N / 2; i++) {
				int temp = map[i][j];
				map[i][j] = map[N - 1 - i][j];
				map[N - 1 - i][j] = temp;
			}
		}
	}
	
	public static void two() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				int temp = map[i][j];
				map[i][j] = map[i][M - 1 - j];
				map[i][M - 1 - j] = temp;
			}
		}
	}
	
	public static void three() {
		int[][] newMap = new int[M][N];
		int x = 0;
		int y = N - 1;

		for (int i = 0; i < N; i++) {
			x = 0;
			for (int j = 0; j < M; j++) {
				newMap[x][y] = map[i][j];
				x++;
			}
			y--;
		}
		
		int temp = N;
		N = M;
		M = temp;
		map = newMap;
	}
	
	public static void four() {
		int[][] newMap = new int[M][N];
		int x = M - 1;
		int y = 0;

		for (int i = 0; i < N; i++) {
			x = M - 1;
			for (int j = 0; j < M; j++) {
				newMap[x][y] = map[i][j];
				x--;
			}
			y++;
		}
		
		int temp = N;
		N = M;
		M = temp;

		map = newMap;
	}
	
	public static void five() {
        int x1 = 0, y1 = 0;
        int x2 = 0, y2 = M / 2;
        int x3 = N / 2, y3 = M / 2;
        int x4 = N / 2, y4 = 0;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                int temp = map[x1][y1];
                map[x1][y1] = map[x4][y4];
                map[x4][y4] = map[x3][y3];
                map[x3][y3] = map[x2][y2];
                map[x2][y2] = temp;
 
                y1++;
                y2++;
                y3++;
                y4++;
            }
            y1 = 0;
            y2 = M / 2;
            y3 = M / 2;
            y4 = 0;
            x1++;
            x2++;
            x3++;
            x4++;
        }
		
	}
	
	public static void six() {
        int x1 = 0, y1 = 0;
        int x2 = 0, y2 = M / 2;
        int x3 = N / 2, y3 = M / 2;
        int x4 = N / 2, y4 = 0;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                int temp = map[x1][y1];
                map[x1][y1] = map[x2][y2];
                map[x2][y2] = map[x3][y3];
                map[x3][y3] = map[x4][y4];
                map[x4][y4] = temp;
 
                y1++;
                y2++;
                y3++;
                y4++;
            }
            y1 = 0;
            y2 = M / 2;
            y3 = M / 2;
            y4 = 0;
            x1++;
            x2++;
            x3++;
            x4++;
        }
	}
}