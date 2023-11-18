import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] timeSchedules = new int[N][2];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			timeSchedules[i][0] = Integer.parseInt(st.nextToken());
			timeSchedules[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(timeSchedules, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
	
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int currEndTime = timeSchedules[0][1];
		int nextStartTime;
		pq.offer(currEndTime);
		
		for(int i = 1; i < N; i++) {
			currEndTime = pq.peek();
			nextStartTime = timeSchedules[i][0];
			if(currEndTime <= nextStartTime) pq.poll();
			pq.offer(timeSchedules[i][1]);
		}
		
		System.out.println(pq.size());
		br.close();
		
	}
}