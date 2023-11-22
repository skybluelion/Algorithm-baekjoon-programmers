import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int I; // 한 변의 길이
    static final int[] dx = {-2,-1,+1,+2,+2,+1,-1,-2};
    static final int[] dy = {+1,+2,+2,+1,-1,-2,-2,-1};
    static boolean[][] isVisited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        Point startP, targetP;
        for(int i = 0; i < T; i++){
            I = Integer.parseInt(br.readLine());
            isVisited = new boolean[I][I];
            map = new int[I][I];
            st = new StringTokenizer(br.readLine());
            startP = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            targetP = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sb.append(bfs(startP,targetP) + "\n");
        }

        System.out.println(sb);
    }
    public static int bfs(Point s, Point t){
        Queue<Point> q = new LinkedList<>();
        q.offer(s);
        Point nextP;
        int x,y = 0;
        boolean flag = false;
        while(!q.isEmpty()){
            Point curr = q.poll();
            isVisited[curr.x][curr.y] = true;
            for(int i = 0; i < 8; i++){
                x = curr.x + dx[i];
                y = curr.y + dy[i];
                if(0 <= x && x < I && 0 <= y && y < I && !isVisited[x][y]) {
                    nextP = new Point(x, y);
                    isVisited[x][y] = true;
                    map[x][y] = map[curr.x][curr.y] + 1;
                    q.offer(nextP);
                    if (nextP.equals(t)) {
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){
                return map[t.x][t.y];
            }
        }
        return 0;
    }
}
