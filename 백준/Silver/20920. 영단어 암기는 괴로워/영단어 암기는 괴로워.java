import java.io.*;
import java.util.*;

public class Main {

	static class Word {
		int count;
		String word;

		Word(int count, String word) {
			this.count = count;
			this.word = word;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Word> arrlist = new ArrayList<>();
		HashMap<String,Integer> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			if(str.length()>=m) map.put(str,map.getOrDefault(str, 0)+1);
		}
		
		for(String str:map.keySet()) arrlist.add(new Word(map.get(str),str));
		
		Collections.sort(arrlist,(w1,w2)->{
			if(w1.count==w2.count) {
				if(w1.word.length()==w2.word.length()) {
					return w1.word.compareTo(w2.word);
				}else {
					return w2.word.length()-w1.word.length();
				}
			}else {
				return w2.count-w1.count;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arrlist.size();i++)sb.append(arrlist.get(i).word).append("\n");
		bw.write(sb+"");
		
		bw.flush();
		bw.close();
		br.close();
	}

}