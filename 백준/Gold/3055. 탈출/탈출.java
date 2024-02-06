import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<int[]> sq = new LinkedList<>();
    static Queue<int[]> wq = new LinkedList<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        map = new char[row][col];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    sq.add(new int[]{i, j, 0});
                } else if (map[i][j] == '*') {
                    wq.add(new int[]{i, j});
                }
            }
        }

        String answer = bfs();
        System.out.println(answer);
    }

    public static String bfs() {
        while (!sq.isEmpty()) {
            int size = wq.size();
            for (int i = 0; i < size; i++) {
                int[] w = wq.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = w[0] + dx[j];
                    int ny = w[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length
                            && (map[nx][ny] == '.' || map[nx][ny] == 'S')) {
                        map[nx][ny] = '*';
                        wq.add(new int[]{nx, ny});
                    }
                }
            }

            int sizeS = sq.size();
            for (int i = 0; i < sizeS; i++) {
                int[] s = sq.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = s[0] + dx[j];
                    int ny = s[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                        if (map[nx][ny] == 'D') {
                            return s[2] + 1 + "";
                        } else if (map[nx][ny] == '.') {
                            map[nx][ny] = 'S';
                            sq.add(new int[]{nx, ny, s[2] + 1});
                        }
                    }
                }
            }
        }
        return "KAKTUS";
    }
}
