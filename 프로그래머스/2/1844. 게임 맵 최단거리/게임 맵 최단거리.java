import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];
        Queue<int[]> q = new LinkedList<>();
        int[] x = {1,0,-1,0};
        int[] y = {0,1,0,-1};

        q.add(new int[]{0,0});
        visited[0][0] = 1;

        while(!q.isEmpty()){
            int[] c = q.remove();
            int cx = c[0];
            int cy = c[1];

            for(int i=0;i<4;i++){
                int dx = cx + x[i];
                int dy = cy + y[i];
                if(dx>=0&&dx<maps.length&&dy>=0&&dy<maps[0].length){
                    if(visited[dx][dy]==0 && maps[dx][dy]==1){
                        q.add(new int[]{dx,dy});
                        visited[dx][dy] = visited[cx][cy]+1;
                    }
                }
            }
        }
        answer = visited[maps.length-1][maps[0].length-1];
        if(answer==0) return -1;
        return answer;
    }
}