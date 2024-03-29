import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int day = 0;
		if((V-A)%(A-B)==0) day = (V-A)/(A-B)+1;
		else day = (V-A)/(A-B)+2;
		
		bw.write(day+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
}