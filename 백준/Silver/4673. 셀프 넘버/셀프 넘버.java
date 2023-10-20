import java.io.IOException;


public class Main {
	final static int N = 10000;
	static boolean[] self = new boolean[N + 1];
	public static void main(String[] args) throws IOException {

		for(int i = 1; i <= N; i++) {
			if(!self[i]) {
				selfCheck(i);
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(!self[i]) {
				System.out.println(i);
			}
		}

	}
	
	public static void selfCheck(int num) {
		int next = 0;
		if(num < 10) {
			next = num + num;
		} else if(num < 100) {
			next = num + num / 10 + num % 10;		
		} else if(num < 1000) {
			next = num + num / 100 + (num % 100) / 10 + num % 10;
		} else if(num < 10000) {
			next = num + num / 1000 + (num % 1000) / 100 + (num % 100) / 10 + num % 10;
		} else if(num == 10000) {
			self[num] = true;
			return;
		}
		
		if(next > 10000) {
			return;
		}
		self[next] = true;
		selfCheck(next);
	}
}
