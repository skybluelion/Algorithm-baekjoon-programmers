import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb =  new StringBuilder();
        StringTokenizer st;
        int H,W,N;
        int X,Y;
        for (int i = 0; i < T; i++) {
        	st = new StringTokenizer(br.readLine());
        	H = Integer.parseInt(st.nextToken());
        	W = Integer.parseInt(st.nextToken());
        	N = Integer.parseInt(st.nextToken());
        	
        	
        	if(N%H==0) {
        		X = H;
        		Y = N/H;
        	}else {
        		X = N%H;
        		Y = N/H+1;
        	}
        	

        	if(Y<10) sb.append(X+"0"+Y+"\n");
        	else sb.append(X+""+Y+"\n");
        }
		
		System.out.println(sb);
		br.close();
	}
}