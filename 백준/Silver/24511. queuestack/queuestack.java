import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		int N = Integer.parseInt(br.readLine());
		int[] typeArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        //각각 자료구조의 개수만큼 어떠한 자료구조를 가지는지 입력(큐 or 스택)
        for(int i = 0; i < N; i++){
			typeArr[i] = Integer.parseInt(st.nextToken());
		}
			
		Deque<Integer> deque = new ArrayDeque<>();
		
		//스택은 들어가자마자 나오기 때문에 자료형이 큐인 것만 저장
		st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
        	int num = Integer.parseInt(st.nextToken());
            if(typeArr[i] == 0){
                deque.addLast(num);
            }
        }
        
        int M = Integer.parseInt(br.readLine()); // 삽입할 수열의 길이

        // 수열을 삽입
        // 첫번째에 넣고 마지막을 뺌
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            deque.addFirst(Integer.parseInt(st.nextToken()));
            sb.append(deque.pollLast()+" ");
        }

        System.out.println(sb);
        
	}

}