import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static String input;
	static int target, totalCnt;
	static char[] arr;
	static boolean[] isSelected;
	static boolean flag;
	
	// nPn 순열에서 target번째 문자열은?
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while ((line = br.readLine()) != null) { // 개수가 정해지지 않은 입력 케이스를 모두 받음
			StringTokenizer st = new StringTokenizer(line, " ");
			input = st.nextToken(); // input 문자열
			target = Integer.parseInt(st.nextToken()); // target번째
			totalCnt = 0;
			flag = false;
			
			arr = new char[input.length()];
			isSelected = new boolean[input.length()];
			
			perm(0);
			if (!flag) System.out.println(input + " " + target + " = No permutation");
		}
	}
	
	static void perm(int cnt) {
		if (cnt == input.length()) {
			totalCnt++;
			if (totalCnt == target) {
				flag = true;
				System.out.print(input + " " + target + " = ");
				for (char c:arr) {
					System.out.print(c);
				}
				System.out.println();
			}
			return;
		}
		
		for (int i = 0; i < input.length(); i++) {
			if (flag) return;
			if (isSelected[i]) continue;
			arr[cnt] = input.charAt(i);
			isSelected[i] = true;
			perm(cnt + 1);
			isSelected[i] = false;
		}
	}
}
