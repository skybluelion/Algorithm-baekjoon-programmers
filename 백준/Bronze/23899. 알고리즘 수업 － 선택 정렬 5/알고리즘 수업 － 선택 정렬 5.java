import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static int[] arr2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		arr2 = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		bw.write(selectionSort()+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int selectionSort() {
		for (int i = arr.length-1; i >= 0; i--) {
			if(Arrays.equals(arr, arr2)) return 1;
			int maxIdx = i ; //최소값의 위치
			for (int j = i-1; j >= 0; j--) {
				if(arr[maxIdx] < arr[j] ) maxIdx = j;
			}
			swap(maxIdx, i);
			if(Arrays.equals(arr, arr2)) return 1;
		}
		return 0;
	}
	
	private static void swap(int i, int j) { // i, j번째 인덱스의 값 교환
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}	
}