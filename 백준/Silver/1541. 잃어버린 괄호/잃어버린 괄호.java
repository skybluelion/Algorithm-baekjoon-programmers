import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
        int cnt = 0;
		StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");

		while(subtraction.hasMoreTokens()) {
			int temp = 0;
			StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");
            
			while(addition.hasMoreTokens()) {
				temp += Integer.parseInt(addition.nextToken());
			}
			
			if(cnt == 0) sum = temp;
			else sum -= temp;

			cnt++;
		}
		
		System.out.println(sum);
	}
}