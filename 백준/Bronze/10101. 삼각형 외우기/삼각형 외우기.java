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
		
		int A = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int sum = A+B+C;
		if(sum == 180) {
			if(A==B && B ==C) bw.write("Equilateral");
			else if(A!=B && B!=C && C!=A) bw.write("Scalene");
			else bw.write("Isosceles");			
		}else bw.write("Error");
		bw.flush();
		bw.close();
		br.close();
	}
}