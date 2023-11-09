import javax.management.QueryEval;
import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[][] isVisited;
    static boolean[][] sink;
    static int[][] arrH;
    static int[] dx = { 0,  0, -1, +1};
    static int[] dy = {-1, +1,  0,  0};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arrH = new int[N][N];
        int maxHeight = Integer.MIN_VALUE;
        int maxArea = 1;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arrH[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, arrH[i][j]);
            }
        }

        for(int h = 0; h <= maxHeight; h++){
            isVisited = new boolean[N][N];
            sink = new boolean[N][N];
            setSink(h);
            cnt = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!isVisited[i][j]&& !sink[i][j]){
                        bfs(i, j);
                    }
                }
            }
            maxArea = Math.max(maxArea, cnt);
        }
        System.out.print(maxArea);

    }

    public static void bfs(int startX, int startY){
        cnt ++;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX,startY));
        isVisited[startX][startY] = true;
        while (!q.isEmpty()){
            Point currP = q.poll();
            for(int i = 0; i < 4; i++){
                int nextX = currP.x + dx[i];
                int nextY = currP.y + dy[i];
                if(0 <= nextX && nextX < N && 0 <= nextY && nextY < N
                        && !sink[nextX][nextY] && !isVisited[nextX][nextY]){
                    isVisited[nextX][nextY] = true;
                    q.offer(new Point(nextX,nextY));
                }
            }
        }
    }

    public static void setSink(int height){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arrH[i][j] <= height){
                    sink[i][j] = true;
                }
            }
        }
    }


}