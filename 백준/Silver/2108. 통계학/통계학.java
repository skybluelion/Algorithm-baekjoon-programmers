import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[8001];
		double sum = 0;
		int avg = 0;
		int max = -4001;
		int min = 4001;
		int cnt = 0;
		int most = 0;
		int mostNum= 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int su = Integer.parseInt(st.nextToken());
			arr[su+4000] ++;
			sum += su;
			max = Math.max(max, su);
			min = Math.min(min, su);
		}
		
		//산술평균 출력
		if(sum >= 0) {
			avg = (int)Math.round(sum / N);
		}else {
			if(-0.5 < sum / N) avg = 0;
			avg = -(int)Math.round(Math.abs(sum / N));			
		}
		
		//중앙값
		int mid = 0;
		for (int i = 0; i < 8001; i++) {
			if(arr[i] != 0) cnt += arr[i];
			if(cnt >= (N+1)/2) {
				mid = i-4000;
				break;
			}
		}
		//최빈값
		int f = 0;
		for (int i = 0; i < 8001; i++) {
			if(arr[i]>most) {
				most = arr[i];
				f = i;
				mostNum = i-4000;
			}
		}
		//최빈값이 여러개 일때 두번째값,
		for (int i = 0; i < 8001; i++) {
			if(arr[i] == most && i != f) {
				mostNum = i-4000;
				break;
			}
		}
		
		//범위
		int gap = max - min;
		int hap=0;
		for (int i : arr) {
			hap += i;
		}
		//hap은 주어진 값이 하나 라면, 범위는 0
		if(hap==1) gap = 0;
		
		bw.write(avg + "\n" + mid + "\n" + mostNum + "\n" + gap);
		
		bw.flush();
		bw.close();
		br.close();
	}
}