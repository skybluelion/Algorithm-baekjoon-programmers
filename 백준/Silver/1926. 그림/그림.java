import java.io.*;
import java.util.*;

public class Main {
	
    static int[] dx = {-1,+1, 0, 0};
    static int[] dy = { 0, 0,-1,+1};
    static int N, M;
    static int size;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int cnt = 0;
        int max = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 1) {
                    cnt++;
                    size = 0;
                    dfs(i, j);
                    max = Math.max(size, max);
                }
            }
        }
        System.out.println(cnt + "\n" + max);
    }

    public static void dfs(int x, int y){
        map[x][y] = 0; 
        size++; 

        for(int d = 0 ; d < 4 ; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1){
                dfs(nx, ny);
            }
        }
    }
}
