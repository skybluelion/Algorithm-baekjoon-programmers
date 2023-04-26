import java.io.*;

public class Main {

	/*
	   무한히 반복되기 때문에 KMP를 이용해 배열의 맨 끝수 즉 접두사와 접미사가 동일한 개수만큼 전체 길이에서 빼주면 된다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();

		bw.write(L-shortAd(str)+"");
		bw.flush();
		bw.close();
		br.close();
	}//main
	
	private static int shortAd(String adString) {
		int leng = adString.length();
		int[] arr = new int[leng]; // 해당 문자열의 접두사와 접미사 동일한 개수 담는 배열
		int index = 0; //접두사 탐색 위치
		
		// 문자가 같을때 && 연달아 같지 않을때 idx = table[idx-1], 즉
		//abaab
		//00112

		for(int i = 1; i < leng; i++) {
			while(index>0 && adString.charAt(i) != adString.charAt(index)) {
				index = arr[index-1];
			}
				
			if(adString.charAt(i) == adString.charAt(index)) {
				arr[i] = ++index;
			}
		}
		return arr[leng - 1];
	}//shortAd
}//class