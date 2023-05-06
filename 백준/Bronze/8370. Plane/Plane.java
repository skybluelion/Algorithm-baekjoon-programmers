import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int result = 0;
    	for (int i = 0; i < 2; i++) {
    		result += Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
		}
    	
    	System.out.println(result);
    	br.close();
    }
}