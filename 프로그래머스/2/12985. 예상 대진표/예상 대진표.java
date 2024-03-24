class Solution {
    public int solution(int n, int a, int b) {
        int cnt = 0;
        
        for(int i = n / 2; i >= 0; i--){
            if(a == b) break;
            if(a % 2 == 1) a += 1;
            a /= 2;
            
            if(b % 2 == 1) b += 1;
            b /= 2;
            
            cnt++;
        }
        return cnt;
    }
}