import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int n = str.length();
		int max = 0;
        for(int i = 0; i < n; i++)
            max = Math.max(max, kmp(str.substring(i, n)));
		bw.write(max+"");
		bw.flush();
		bw.close();
		br.close();
	}//main
	
	private static int kmp(String adString) {
		int leng = adString.length();
		int[] arr = new int[leng]; // 해당 문자열의 접두사와 접미사 동일한 개수 담는 배열
		int index = 0; //접두사 탐색 위치
		int max = 0;
		
		// 문자가 같을때 && 연달아 같지 않을때 idx = table[idx-1], 즉
		//abaab
		//00112

		for(int i = 1; i < leng; i++) {
			while(index>0 && adString.charAt(i) != adString.charAt(index)) {
				index = arr[index-1];
			}
				
			if(adString.charAt(i) == adString.charAt(index)) {
				arr[i] = ++index;
				max = Math.max(max, arr[i]);
			}
		}
		return max;
	}
}//class