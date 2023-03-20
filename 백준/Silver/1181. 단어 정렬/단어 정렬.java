import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		String[] arr = new String[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken();
		}
		
		String[] resultArr = Arrays.stream(arr).distinct().toArray(String[]::new);
		Arrays.sort(resultArr);
		Arrays.sort(resultArr, (String s1, String s2) -> s1.length() - s2.length());
		for (int i = 0; i < resultArr.length; i++) {
			bw.write(resultArr[i]+"\n");			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
