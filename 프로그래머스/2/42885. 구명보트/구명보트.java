import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        //정렬
        Arrays.sort(people);
        int[] sortedPeople = new int[people.length];
        int idx = 0;
        for(int i = people.length - 1; i >= 0; i--){
            sortedPeople[idx++] = people[i];
        }
        
        //
        int endIdx = people.length - 1;
        int currWeight, endWeight, sum = 0;
        
        for(int currIdx = 0; currIdx < people.length; currIdx++){
            currWeight = sortedPeople[currIdx];
            endWeight = sortedPeople[endIdx];
            sum = currWeight + endWeight;

            if(endIdx - currIdx < 0) break;
            else{
                answer++;
                if(limit - currWeight < 40) continue;
                    if(limit >= sum){
                        endIdx--;

                    }
            }
        }
        return answer;
    }
}