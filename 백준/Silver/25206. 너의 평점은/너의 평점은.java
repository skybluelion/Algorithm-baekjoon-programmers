import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Score {
	String sub;
	String h;
	String score;
	
	public Score(String sub, String h, String score) {
		super();
		this.sub = sub;
		this.h = h;
		this.score = score;
	}
	public Score() {
		super();
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = 20;
		double sum = 0;
		double hSum = 0;

		Score [] scores = new Score [N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			scores[i] = new Score(st.nextToken(),st.nextToken(),st.nextToken());
		}
			
		for (int i = 0; i < N; i++) {
			switch(scores[i].score) {
				case "A+":
					scores[i].score = "4.5";
					break;
				case "A0":
					scores[i].score = "4.0";
					break;
				case "B+":
					scores[i].score = "3.5";
					break;
				case "B0":
					scores[i].score = "3.0";
					break;
				case "C+":
					scores[i].score = "2.5";
					break;
				case "C0":
					scores[i].score = "2.0";
					break;
				case "D+":
					scores[i].score = "1.5";
					break;
				case "D0":
					scores[i].score = "1.0";
					break;
				case "F":
					scores[i].score = "0.0";
					break;
				case "P":
					scores[i].score = "0.0";
					scores[i].h = "0.0";
					break;
			}
			hSum += Double.parseDouble(scores[i].h);
			sum += Double.parseDouble(scores[i].h)*Double.parseDouble(scores[i].score);
		}
		if(hSum == 0)bw.write("0.000000"+"");
		else bw.write(String.format("%f", sum/hSum ) +"");

		bw.flush();
		bw.close();
		br.close();	
	}

}