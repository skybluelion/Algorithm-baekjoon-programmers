import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(st.nextToken());
		arr = new int [N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int card = Integer.parseInt(st.nextToken());
			bw.write(search(card, 0, N-1)+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	public static int search(int key, int low, int high) {
		int mid;
		
		if(low <= high) {
			mid = (low + high) / 2 ;
			
			if(key == arr[mid]) {
				return 1;
			} else if(key < arr[mid]) {
				return search(key, low, mid-1);
			} else {
				return search(key, mid+1, high);
			}
		}
		
		return 0; // 실패
	}
}