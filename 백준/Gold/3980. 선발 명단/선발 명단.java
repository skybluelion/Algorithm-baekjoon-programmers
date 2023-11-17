import java.util.*;
import java.io.*;

public class Main {
    static int[][] ability;
    static boolean[] visited;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int max;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        for(int c = 0; c < C; c++){
            ability = new int[11][11];
            visited = new boolean[11];
            max = 0;
            readPosition();
            backtrack(0, 0);
            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }

    static void readPosition() throws IOException {
        for(int i = 0; i < 11; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 11; j++){
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    static void backtrack(int player, int sum){
        if(player == 11){
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<11; i++){
            if(ability[i][player] == 0 || visited[i]) continue;
            visited[i] = true;
            backtrack(player + 1, sum+ability[i][player]);
            visited[i] = false;
        }
    }
}
