import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Deque<int[]> q = new ArrayDeque<>();
		List<Integer> answer = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
            int[] arr= {i+1, Integer.parseInt(st.nextToken())};
            q.add(arr);
		}
		
        while(q.size() > 1){
            int[] arr= q.pollFirst();
            answer.add(arr[0]);
            int n = arr[1];
            if(n>0) {
                for(int j=1; j<n;j++) {
                    q.offerLast(q.pollFirst());
                }
            }
            else if(n<0){
                for(int j=n;j!=0;j++) {
                    q.offerFirst(q.pollLast());
                }
            }
        }
        
        answer.add(q.poll()[0]);
        for(int idx : answer) {
        	System.out.print(idx + " ");
        }
	}

}