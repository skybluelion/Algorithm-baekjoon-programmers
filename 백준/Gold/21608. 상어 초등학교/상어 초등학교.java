import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] score = {0, 1, 10, 100, 1000};
    static int result = 0;
    static int[][] likeArr;
    static Queue<Integer> student;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        likeArr = new int[N * N + 1][4];
        map = new int[N][N];
        student = new LinkedList<>();
        for(int i = 0; i < N * N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            student.add(num);
            for(int j = 0; j < 4; j++){
                likeArr[num][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = solve();

        System.out.println(answer);
    }

    public static int solve() {
        int likeCnt = 0;
        int emptyCnt = 0;
        while(!student.isEmpty()){
            int num = student.poll();
            int x = -1;
            int y = -1;
            int like = -1;
            int empty = -1;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] != 0) continue;
                    likeCnt = 0;
                    emptyCnt = 0;
                    for(int k = 0; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if(map[nx][ny] == 0) emptyCnt++;
                        for(int l = 0; l < 4; l++){
                            if(map[nx][ny] == likeArr[num][l]){
                                likeCnt++;
                                break;
                            }
                        }
                    }
                    if(likeCnt > like || (likeCnt == like && emptyCnt > empty)){
                        x = i;
                        y = j;
                        like = likeCnt;
                        empty = emptyCnt;
                    }
                }
            }
            map[x][y] = num;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                likeCnt = 0;
                for(int k = 0; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    for(int l = 0; l < 4; l++){
                        if(map[nx][ny] == likeArr[map[i][j]][l]){
                            likeCnt++;
                            break;
                        }
                    }
                }
                result += score[likeCnt];
            }
        }
        return result;
    }
}
