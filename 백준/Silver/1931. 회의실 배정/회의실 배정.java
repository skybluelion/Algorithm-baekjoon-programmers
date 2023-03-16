import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Meeting {
	int start, end;

	public Meeting(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(st.nextToken());
		Meeting[] meetings = new Meeting[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		//끝나는 시간 기준으로 오름차순 정렬
		Arrays.sort(meetings, (m1,m2) -> m1.end != m2.end ?
				m1.end - m2.end : m1.start - m2.start); // 람다함수 파라메터 -> 리턴
	
		ArrayList<Meeting> result = new ArrayList();
		result.add(meetings[0]);
		for (int i = 1; i < N; i++) {
			//마지막에 추가된 미팅의 끝나는 시간과 다음에 올 시작지점 비교해서 겹치지 않는 구간에서 추가
			if(result.get(result.size()-1).end <= meetings[i].start)  {
				result.add(meetings[i]);
			}
		}
		bw.write(result.size()+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	
}
