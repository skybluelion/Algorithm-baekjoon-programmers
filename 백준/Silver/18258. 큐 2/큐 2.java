import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		Deque<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	String str = st.nextToken();
	    	switch(str) {
	    	case "push":
	    		q.offer(Integer.parseInt(st.nextToken()));
	    		break;
	    	case "pop":
    			if(q.isEmpty()) bw.write(-1+"\n");
	    		else {
		    		int A = q.poll();
    				bw.write(A+"\n");	
    			}
    			break;
    		case "size":
    			bw.write(q.size()+"\n"); 
    			break;
    		case "empty":
    			if(q.isEmpty()) bw.write(1+"\n");
	    		else bw.write(0+"\n");
		    	break;
       		case "front":
	    		if(q.isEmpty()) bw.write(-1+"\n");
		    	else bw.write(q.peek()+"\n");
	    		break;
	    	default:
	    		if(q.isEmpty()) bw.write(-1+"\n");
	    		else bw.write(q.peekLast()+"\n");
	    		break;
		    }
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}