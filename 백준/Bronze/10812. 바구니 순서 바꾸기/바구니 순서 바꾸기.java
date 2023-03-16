import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	
	static int[] arr;
	static int begin, end, mid;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int [N+1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			begin = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			mid = Integer.parseInt(st.nextToken());
			swap(begin, end, mid);
		}
		
		for (int i = 1; i <= N; i++) {
			bw.write(arr[i]+" ");
		}

		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void swap(int i, int j, int k) {
		
		ArrayList<Integer> newArr = new ArrayList();
		//mid~end

		for (int a = 0; a <= j-k; a++) {
			newArr.add(arr[k+a]);
		}
		//begin~mid-1
		for (int a = 0; a < k-i; a++) {
			newArr.add(arr[i+a]);
		}
		//값교환
		for (int l = 0; l <= j-i; l++) {
			arr[i+l] = newArr.get(l);
		}
	}
}