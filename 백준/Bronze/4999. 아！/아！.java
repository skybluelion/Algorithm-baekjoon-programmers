import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String jWord = br.readLine();
		String dWord = br.readLine();
		
		if(jWord.length()<dWord.length()) System.out.println("no");
		else System.out.println("go");
		br.close();
	}

}
