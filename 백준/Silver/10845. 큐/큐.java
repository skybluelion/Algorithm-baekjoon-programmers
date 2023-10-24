import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push": {
				q.add(Integer.parseInt(st.nextToken()));
				break;
				}
			case "pop": {
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.poll());
				break;
				}
			case "empty": {
				if(q.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
				}
			case "front": {
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.peek());
				break;
				}
			case "back": {
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.peekLast());
				break;
				}
			default:
				System.out.println(q.size());
				break;
			}
		}
		
		br.close();
	}

}
