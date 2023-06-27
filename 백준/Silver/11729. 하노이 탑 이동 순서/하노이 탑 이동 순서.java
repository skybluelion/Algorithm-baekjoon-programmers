import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
 
		sb.append((int) (Math.pow(2, N) - 1)).append('\n');
		Hanoi(N, 1, 2, 3);
		System.out.println(sb);
	}
 

 
	public static void Hanoi(int N, int from, int mid, int to) throws IOException {
		/*
			N : 원판의 개수 
			from : 출발지 
			mid : 옮기기 위해 이동해야 장소 
			to : 목적지
		 */
		
		// 이동할 원반의 수가 1개일 때
		if (N == 1) {
			sb.append(from + " " + to + "\n");
			return;
		}

		Hanoi(N - 1, from, to, mid);
		sb.append(from + " " + to + "\n");
		Hanoi(N - 1, mid, from, to);
 
	}
}