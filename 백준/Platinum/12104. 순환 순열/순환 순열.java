import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String A = br.readLine();
		String B = br.readLine();
		sb.append(B+B).deleteCharAt(B.length()*2-2);
		String newB = sb.toString();
		bw.write(kmp(A,newB)+"");
		bw.flush();
		bw.close();
		br.close();
	}//main
	

	private static int[] kmpA(String strA) {
		int leng = strA.length();
		int[] arrA = new int[leng];
		int index = 0;
		for (int i = 1; i < leng; i++) {
			while (index>0 && strA.charAt(i) != strA.charAt(index)) {
				index = arrA[index-1];
			}
			if (strA.charAt(i) == strA.charAt(index)) {
				arrA[i] = ++index;
			} else {
				arrA[i] = 0;
			}
		}
		return arrA;
	}

	private static int kmp(String strA, String strB) {
		int cnt = 0;
		int leng = strB.length();
		int[] arrA = kmpA(strA);
		int index = 0;
		for (int i = 0; i < leng; i++) {
			while (index>0 && strB.charAt(i) != strA.charAt(index)) {
				index = arrA[index-1];
			}
			if (strB.charAt(i) == strA.charAt(index)) {
				index++;
				if (index == strA.length()) {
					cnt++;
					index = arrA[index-1];
				}
			}
		}
		return cnt;
	}
}//class