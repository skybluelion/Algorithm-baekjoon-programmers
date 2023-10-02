import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int K;
	static int cnt[] = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(N));
	}
	
	private static int  bfs(int currPoint) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(currPoint);
		cnt[currPoint] = 1;
		int n = 0;
		while (!queue.isEmpty()) {
			n = queue.poll();
			if (n == K) {
				return cnt[n]-1;
			}
			
			if (n - 1 >= 0 && cnt[n - 1] == 0) {
				cnt[n - 1] = cnt[n] + 1;
				queue.add(n - 1);
			}
			
			if (n + 1 <= 100000 && cnt[n + 1] == 0) {
				cnt[n + 1] = cnt[n] + 1;
				queue.add(n + 1);
			}
			
			if (2 * n <= 100000 && cnt[2 * n] == 0) {
				cnt[2 * n] = cnt[n] + 1;
				queue.add(2 * n);
			}
		}
		
		return -1;
	}
}