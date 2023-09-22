import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] B = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		int temp = 0;
		
		if(Arrays.equals(A, B)) {
			System.out.println(1);
			System.exit(0);
		}
		
		//비교하는 index
		int last = N - 1;
		int last2 = 0;
		
		for(int i = 0; i < N-1; i++) {
			if(last == 0) break;
			
			int cnt = 0;
			for(int j = 0; j < last; j++) {
				if(A[j] > A[j+1]) {
					temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
					cnt++;
					last2 = j;
					if(A[j] == B[j] && Arrays.equals(A, B)) {
						System.out.println(1);
						System.exit(0);
					}
				}
			}
			last = last2;
			
			if(cnt == 0) break;
		}
		
		System.out.println(0);
        
	}

}