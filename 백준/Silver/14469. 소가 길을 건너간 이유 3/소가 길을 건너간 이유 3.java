import java.io.*;
import java.util.*;

public class Main {
	
	static class Cow implements Comparable<Cow> {
		int enter;
		int time;
		
		@Override
		public int compareTo(Main.Cow o) {
			if(this.enter != o.enter) return this.enter-o.enter;
			return this.time - o.time;
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        Cow[] cows = new Cow[N];

        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	Cow cow = new Cow();
            cow.enter = Integer.parseInt(st.nextToken());
            cow.time = Integer.parseInt(st.nextToken());
            cows[i] = cow;
        }
        Arrays.sort(cows);
        int now = 0;
        for (Cow cow : cows) {
            if (cow.enter >= now) now += cow.enter - now;
            now += cow.time;
        }
        bw.write(now+"");

        bw.flush();
        bw.close();
        br.close();
    }
}