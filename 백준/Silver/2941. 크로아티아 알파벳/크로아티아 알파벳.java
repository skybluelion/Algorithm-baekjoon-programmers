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
		String arr[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};	
		for (int i = 0; i < arr.length; i++) 
			if(str.contains(arr[i])) str = str.replace(arr[i], "a");
		bw.write(str.length()+"");
		bw.flush();
		bw.close();
		br.close();
	}
}