import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		HashMap<Integer,Integer> map = new HashMap<>();
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int next = Integer.parseInt(st.nextToken());
			if(!map.containsKey(next)) {
				map.put(next, next);
				arr.add(next);
			}
			result.add(Integer.toString(next));
		}
		Collections.sort(arr);
		for (int i = 0; i < arr.size(); i++) map.put(arr.get(i), i);

		for (String i : result) bw.write(map.get(Integer.parseInt(i))+" ");
	
		bw.flush();
		bw.close();
		br.close();
	}
}