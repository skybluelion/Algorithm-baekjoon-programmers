import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 0;
    static int dpCnt = 0;
    static int[] f;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	f = new int[n];
    	fib(n);
    	fibonacci(n);
    	System.out.print(cnt+" ");
    	System.out.println(dpCnt);
    }
    
    public static int fib(int n) {
    	if(n == 1 || n == 2){
    		cnt++;
    		return 1;
    	}
    	return fib(n - 1) + fib(n - 2);
    }
    
    public static int fibonacci(int n) {
    	f[0] = 1;
    	f[1] = 1;
    	
    	for (int i = 2; i < n; i++) {
    		dpCnt++;
    		f[i] = f[i-1] + f[i-2];
    	}
    	return f[n-1];
    }
	
}