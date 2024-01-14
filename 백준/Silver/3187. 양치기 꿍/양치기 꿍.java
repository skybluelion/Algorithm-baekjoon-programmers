import java.io.*;
import java.util.*;

public class Main {
	
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int R;
    static int C;
    static int sheep, wolf = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        isVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int liveSheep = 0;
        int liveWolves = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!isVisited[i][j] && map[i][j] != '#') {
                    sheep = 0; wolf = 0;
                    dfs(i, j);
                    if (sheep > wolf) liveSheep += sheep;
                    else liveWolves += wolf;
                }
            }
        }

        System.out.println(liveSheep + " " + liveWolves);
    }

    private static void dfs(int x, int y) {
        if ('k' == map[x][y]) sheep++;
        else if ('v' == map[x][y]) wolf++;
        
        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < R  && 0 <= ny && ny < C && !isVisited[nx][ny] && map[nx][ny] != '#') {
            	dfs(nx, ny);
            }
        }
    }
}
