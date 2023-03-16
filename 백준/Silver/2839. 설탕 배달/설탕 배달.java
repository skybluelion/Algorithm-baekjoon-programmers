import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		

		for (int i = 0; i <= N/5; i++) {
			for (int j = 0; j <= N/3; j++) {
				if(N == j*3+i*5) {
					sum=i+j;
					break;
				}
				
			}
		}
		if(sum == 0) bw.write(-1+"");
		else bw.write(sum+"");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
