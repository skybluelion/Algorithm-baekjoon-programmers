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
		

		st = new StringTokenizer(br.readLine());

		double[] arr1 = new double[N];
		for (int i = 0; i < N; i++) {
			arr1[i]=Integer.parseInt(st.nextToken()); 
		}
		
		double max = 0;
		for(double score : arr1) {
			if(score > max) {
				max = score;
			}
		}

		
		double[] newArr = new double [N]; 
		double sum = 0;
		for (int i = 0; i < N; i++) {
			newArr[i]=arr1[i]/max*100;
			sum += newArr[i];
		}
		
		double newAvg = sum/N;
		
		bw.write(newAvg+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
}