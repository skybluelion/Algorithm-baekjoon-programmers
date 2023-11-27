class Solution {
    
    static boolean[] isVisited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        isVisited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                dfs(computers, i);
                answer++;
            }
        }
        return answer;
    }
    
    public static void dfs(int[][] computers, int start) {
        isVisited[start] = true;
        for(int next = 0; next < computers.length; next++) {
            if(computers[start][next] == 1 && !isVisited[next] && start != next) {
                dfs(computers, next);
            }
        }
    }
}