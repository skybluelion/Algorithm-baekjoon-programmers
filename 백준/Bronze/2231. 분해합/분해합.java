import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//문자열로 저장
		String str = br.readLine();
		int result = 0;
		//길이
		int L = str.length();
		
		//숫자로 저장
		int N = Integer.parseInt(str);

		for (int i = (N - (L*9)); i < N; i++) {
			int num = i;
			int sum = 0;
			
			while(num != 0) {
				sum += num %10; //각 자리 수 더하기
				num /= 10; // 한자리 수 씩 작아짐.
			}
			if(N == sum + i) {
				result = i;
				break;
			}
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}
}