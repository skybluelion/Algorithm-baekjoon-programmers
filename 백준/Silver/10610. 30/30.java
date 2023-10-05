import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		br.close();
        
		String[] arr = num.split("");
		Arrays.sort(arr, Collections.reverseOrder());
        
		if(arr[arr.length-1].equals("0")) {
            int sum = 0;
			for(int i = 0; i < arr.length; i++) {
				sum += Integer.parseInt(arr[i]);
			}
			if(sum % 3 == 0) {
				for(int i = 0; i < arr.length; i++) {
					System.out.print(arr[i]);
				}
			} else {
			System.out.println(-1);
			return;
		    }
		} else {
			System.out.println(-1);
			return;
		}
	}
}