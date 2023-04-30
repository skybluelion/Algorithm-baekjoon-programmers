import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int time = Integer.parseInt(st.nextToken());
		int alc = Integer.parseInt(st.nextToken());
			
		if(time>=12 && time<=16 && alc==0) bw.write("320");
		else bw.write("280");
		bw.flush();
		bw.close();
		br.close();
	}//main
	
}//class
