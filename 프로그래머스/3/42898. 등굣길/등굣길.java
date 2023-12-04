class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[n + 1][m + 1];
        boolean[][] isBlocked = new boolean[n + 1][m + 1];
        
        for(int[] puddle : puddles){
            isBlocked[puddle[1]][puddle[0]] = true;
        }
        
        map[1][1] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(!isBlocked[i][j]){
                    if(map[i - 1][j] > 0) {
                        map[i][j] += map[i - 1][j] % 1000000007;
                    }
                    if(map[i][j - 1] > 0) {
                        map[i][j] += map[i][j - 1] % 1000000007;
                    }
                }
            }
        }
        
        answer = map[n][m] % 1000000007;
        
        return answer;
    }
}