import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	

		int N = Integer.parseInt(br.readLine());
		int n=0;
		int top=1;
		int bot=1;
		int cnt=0;
		
		if(N==1) bw.write("1/1");
		else {
			while(cnt<N){ //행 찾기
				n++;
				cnt=n*(n+1)/2; 
			}
			int num=N-(n-1)*n/2;  //행 안에서 순서
			if(n%2==0) {  //짝수 행 
				top=num;
				bot=n-num+1;
			}else {	//홀수 행
				top=n-num+1;
				bot=num;
			}
			bw.write(top+"/"+bot);
		}
		bw.flush();
		bw.close();
		br.close();
	}
}