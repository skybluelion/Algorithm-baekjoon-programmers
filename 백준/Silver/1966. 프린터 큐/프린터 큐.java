import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int cnt = 0;
			Queue<int[]> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				q.add(new int[] {j, Integer.parseInt(st.nextToken())});
			}
			
			while (true) {
				int now[] = q.remove();
				boolean flag = true;
				
				for (int queue[] : q) {
					if(queue[1] > now[1]) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					cnt++;
					if(now[0] == M) break;
				}else q.add(now);
			}
			bw.write(cnt+"\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}