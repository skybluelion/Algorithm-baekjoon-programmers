import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] temp;
    static boolean[] isVisited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        temp = new int[N / 2];
        isVisited = new boolean[N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0);
        System.out.print(min);
    }

    public static void comb(int curr, int depth) {
        if(depth == N / 2){
            sumTeamScore();
            return;
        }
        for(int i = curr; i < N; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                comb(i + 1, depth + 1);
                isVisited[i] = false;
            }
        }
    }


    public static void sumTeamScore(){
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isVisited[i] && isVisited[j]) {
                    teamStart += arr[i][j];
                    teamStart += arr[j][i];
                } else if (!isVisited[i] && !isVisited[j]) {
                    teamLink += arr[i][j];
                    teamLink += arr[j][i];
                }
            }
        }

        min = Math.min(Math.abs(teamStart - teamLink), min);
    }
}
