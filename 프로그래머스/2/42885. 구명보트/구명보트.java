import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        Deque<Integer> dq = new LinkedList<>();
        for(int i = people.length - 1; i >= 0; i--){
            dq.add(people[i]);
        }
        int temp = 0;
        while(true){
            if(dq.size() == 1){
                dq.poll();
                answer++;
                break;
            }else{
                temp = dq.pollFirst();
                if(limit >= temp + dq.peekLast()){
                    temp = dq.pollLast();
                }
                answer++;
                if(dq.isEmpty()) break;
            }
        }
        return answer;
    }
}