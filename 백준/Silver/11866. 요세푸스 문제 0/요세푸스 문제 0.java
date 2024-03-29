import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> q = new LinkedList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) q.add(i);
		
		int cnt = 1;
		bw.write("<");
		while(!q.isEmpty()) {
			if(cnt == K) {
				bw.write(q.poll()+"");
				if(q.isEmpty()) break;
				bw.write(", ");
				cnt = 1;
			}else {
				q.add(q.poll());
				cnt++;
			}
		}
		bw.write(">");
		bw.flush();
		bw.close();
		br.close();
	}
}