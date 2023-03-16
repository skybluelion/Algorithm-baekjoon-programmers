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
		String[] chk = str.split("");
		boolean flag = true;

		for (int i = 0; i < chk.length/2; i++) {
			if(chk[i].equals(chk[chk.length-1-i])) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}	
		
		if(flag == false) {
			bw.write(0+"");
		} else {
			bw.write(1+"");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
	
}