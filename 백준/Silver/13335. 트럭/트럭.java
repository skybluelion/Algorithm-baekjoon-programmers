import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
        
        // 트럭의 수
		int n = Integer.parseInt(st.nextToken());
		// 다리의 길이	
		int w = Integer.parseInt(st.nextToken());
		// 다리의 최대 하중
		int l = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Queue<Integer> truck = new LinkedList<>();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}
        
		// 다리 길이만큼 0 담기		
		for(int i=0;i<w;i++) {
			q.add(0);
		}
        
		// 다리위에 올라간 트럭의 합
		int wSum = 0;

		int time = 0;
		while (true) {
			time++;
			wSum -= q.poll();
			if (!truck.isEmpty()) {
				if (truck.peek() + wSum <= l) {
					wSum += truck.peek();
					q.add(truck.poll());
				}else {
					q.add(0);
				}
			}
			if(q.isEmpty()) break;
		}
		System.out.println(time);
	}
}