import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	

		int T = Integer.parseInt(st.nextToken());
	    ArrayList<Integer> prime = new ArrayList<>();
        boolean[] num = new boolean[1000001];
        num[0] = num[1] = true;
        for (int i = 2; i < 1000001; i++) {
        	if(num[i] == false){
                prime.add(i);
                for(int j = i+i; j < 1000001; j+=i) num[j] = true;
            }
        }

        while(T-- > 0){
        	st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int result = 0;
            for(int i = 0; prime.get(i) <= N/2 ; i++){
                if(num[N - prime.get(i)] == false) {
                    result++;
                }
            }
			bw.write(result+"\n");
		}
        
        bw.flush();
        bw.close();
        br.close();
    }
}