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
		

		String str = st.nextToken();
		String[] arr = str.split("");
		
		int[] A = new int[(int)('z'-'a'+1)];
		for (int i = 0; i < A.length; i++) {
			A[i]=-1;
		}

		
		int num;
		for (int i = 0; i < arr.length; i++) {
			num = (int)arr[i].charAt(0)-97;
			if(A[num] == -1) A[num] = i;
		}

		for (int i = 0; i < A.length; i++) {
			bw.write(A[i]+" ");
		}
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}