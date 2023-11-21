import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] arr;
    static ArrayList<Point> homes, chicken;
    static Point[] selectedChicken;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        homes = new ArrayList<>();
        chicken = new ArrayList<>();
        selectedChicken = new Point[M];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    homes.add(new Point(i, j));
                }else if(arr[i][j] == 2){
                    chicken.add(new Point(i, j));
                }
            }
        }
        combination(chicken.size(), M, 0, 0);
        System.out.println(answer);
    }

    public static void combination(int n, int r, int index, int target) {
        if(r == 0){
            int totalDistance = 0;
            for(Point home : homes){
                int minDistance = Integer.MAX_VALUE;
                for(Point chickenHome : selectedChicken){
                    int distance = Math.abs(home.x - chickenHome.x) + Math.abs(home.y - chickenHome.y);
                    minDistance = Math.min(minDistance, distance);
                }
                totalDistance += minDistance;
            }
            answer = Math.min(answer, totalDistance);
        }else if(target == n){
            return;
        }else{
            selectedChicken[index] = chicken.get(target);
            combination(n, r-1, index+1, target+1);
            combination(n, r, index, target+1);
        }
    }
}
