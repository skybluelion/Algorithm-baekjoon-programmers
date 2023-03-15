import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = "         ,r'\"7\n"
				+ "r`-_   ,'  ,/\n"
				+ " \\. \". L_r'\n"
				+ "   `~\\/\n"
				+ "      |\n"
				+ "      |";
		
		bw.write(str);
		bw.flush();
		bw.close();

	}
}
