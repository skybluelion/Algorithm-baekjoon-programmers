import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int max,min;
	static int[] Operator;
	static int[] A;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		
		Operator = new int[4]; // plus, minus, mul, div
		int sum = 0;
		for(int i = 0; i < 4; i++) {
			Operator[i] = Integer.parseInt(st.nextToken());
			sum += Operator[i];
		}
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		dfs(A[0], 1);
		System.out.println(max + "\n" + min);
		
	}
	
	   public static void dfs(int num, int idx) {
	        if (idx == N) {
	            max = Math.max(max, num);
	            min = Math.min(min, num);
	            return;
	        }

	        for (int i = 0; i < 4; i++) {
	            // 연산자 개수가 1개 이상인 경우
	            if (Operator[i] > 0) {
	                Operator[i]--;

	                switch (i) {
	                    case 0:
	                        dfs(num + A[idx], idx + 1);
	                        break;
	                    case 1:
	                        dfs(num - A[idx], idx + 1);
	                        break;
	                    case 2:
	                        dfs(num * A[idx], idx + 1);
	                        break;
	                    case 3:
	                        dfs(num / A[idx], idx + 1);
	                        break;
	                }

	                // 재귀 호출이 종료되면 다시 해당 연산자 개수를 복구
	                Operator[i]++;
	            }
	        }
	   }
	
}
