import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] arr = new int[4][2];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		double[] leng = new double[3];
		arr[3][0]=arr[0][0];
		arr[3][1]=arr[0][1];

		for (int i = 0; i < 3; i++) {
			leng[i] = Math.sqrt(Math.pow((arr[i][0]-arr[i+1][0]),2)+Math.pow((arr[i][1]-arr[i+1][1]),2));
			
		}
		Arrays.sort(leng);
		
		double g1= 0;
		double g2= -1;
		
		if(arr[0][0]==arr[1][0] && arr[1][0]==arr[2][0]) { //x좌표가 같을때
			g1 = 0;
			g2 = 0;
		}else if((arr[0][0]-arr[1][0]) * (arr[0][1]-arr[2][1]) == (arr[0][1]-arr[1][1]) * (arr[0][0]-arr[2][0])){ //기울기가 같을 때
			g1 = 0;
			g2 = 0;
		}else if(arr[0][1]==arr[1][1] && arr[1][1]==arr[2][1]){ //y좌표가 같을 때
			g1 = 0;
			g2 = 0;
		}
		
		if(g1==g2) bw.write(-1.0+"");
		else bw.write(2*(leng[2]-leng[0])+"");
		bw.flush();
		bw.close();
		br.close();
	}
}