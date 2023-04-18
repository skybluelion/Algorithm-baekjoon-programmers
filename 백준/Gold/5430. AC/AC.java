import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			int n = Integer.parseInt(br.readLine());
			//[],제외 모두 읽기
			StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
			Deque<Integer> deq = new ArrayDeque<>();

			for(int j = 0; j < n; j++) {
				deq.add(Integer.parseInt(st.nextToken()));
			}
			bw.write(AC(deq, str)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static String AC(Deque<Integer> deque, String commands) {
        boolean reverse = false;
        for (char c : commands.toCharArray()) {
            if (c == 'R') reverse = !reverse;
            else {
                if (deque.size() == 0) return "error";
                //현재 방향에 따라 지워주면 된다.
                else {
                	if (reverse) deque.removeLast();
                	else deque.removeFirst();
                }
            }
        }
        StringBuilder sb = new StringBuilder("[");
        while (!deque.isEmpty()) {
        	//R의 따라 마지막에만 뒤집어주면 된다.
            sb.append(reverse ? deque.removeLast() : deque.removeFirst());
            if (deque.size() != 0) sb.append(',');
        }
        sb.append(']');
        return sb.toString();
    }
}