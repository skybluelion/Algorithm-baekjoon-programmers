import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		String[] arr = str.split(" ");
		int blkCnt = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == "") blkCnt++;
		}
		bw.write(arr.length-blkCnt+"");

	
		bw.flush();
		bw.close();
		br.close();
	}
}