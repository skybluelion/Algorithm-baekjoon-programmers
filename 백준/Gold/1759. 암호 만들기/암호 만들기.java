import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int C, L;
	static String[] strs; // 선택한 문자열
	static String[] arr; // 사용자 입력 배열
	
	static int mo;
	static int ja;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		strs = new String[L];
		arr = new String[C];
		
		for (int i = 0; i < C; i++) {
			arr[i] = sc.next();
		}
		Arrays.sort(arr);

		comb(0, 0);

	}
	
	
	//cnt : cnt번째 문자열 뽑기
	//startIndex : arr에서 startIndex부터 문자열 뽑기 -> 따라서 isSelected로 중복 확인 안해도됨.
	private static void comb(int cnt, int startIndex) {
		if(cnt == L) {
			haveStr();
			if(mo >= 1 && ja >= 2) {
				for (int i = 0; i < strs.length; i++) {
					System.out.print(strs[i]);
				}
				System.out.println();
				
			}
			return;
		}
		for (int i = startIndex; i < C; i++) {
			strs[cnt] = arr[i]; //cnt번째 숫자를 배열의 i번째 숫자로 지정
			comb(cnt+1, i+1);
		}
	}
	
	private static void haveStr() {
		mo = 0;
		ja = 0;
		for(String str : strs) {
			if(str.equals("a") || str.equals("e") || str.equals("i") || str.equals("o") || str.equals("u")) {
				mo++;
			} else {
				ja++;
			}	
		}
		return;
	}

}

