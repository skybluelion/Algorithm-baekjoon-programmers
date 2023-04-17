import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer> q = new LinkedList<>();
		for (int j = 1; j <= N; j++) q.add(j);
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int A = Integer.parseInt(st.nextToken());
			while(true) {
				ArrayList<Integer> arr = new ArrayList<>();
				arr.addAll(q);
				if(A==q.peekFirst()) {
					q.pollFirst();
					break;
				}
				else {
					if(arr.indexOf(A)<arr.size()/2+1) {
						q.addLast(q.pollFirst());
						cnt++;
					}
					else {
						q.addFirst(q.pollLast());
						cnt++;
					}
				}
			}
		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}
}