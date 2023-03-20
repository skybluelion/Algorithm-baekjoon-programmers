import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Member implements Comparable<Member> {
	int age;
	String name;
	
	public Member(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	 public String getName() {
		 return name;
	 }
	 
	 public int getAge() {
		 return age;
	 }
	
	@Override
    public int compareTo(Member o) {
		return this.age - o.getAge();
	}
        
    
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());

		Member[] member = new Member[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			member[i] = new Member(Integer.parseInt(st.nextToken()),st.nextToken());
		}
		
		Arrays.sort(member);
		for (int i = 0; i < N; i++) {
			bw.write(member[i].age + " " + member[i].name + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
