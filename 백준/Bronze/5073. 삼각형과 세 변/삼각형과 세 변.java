import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A = 1000,B,C;
		while(A != 0) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(A == 0) break;
			if(A>=B+C || B>=C+A || C>=A+B) bw.write("Invalid\n");
			else {
				if(A == B && B == C) bw.write("Equilateral\n");
				else if ( A!=B && B!=C && C!=A) bw.write("Scalene\n");
				else bw.write("Isosceles\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}