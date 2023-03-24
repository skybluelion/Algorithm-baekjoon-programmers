import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int n;

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));    

    int a1 = Integer.parseInt(st.nextToken());
    int a0 = Integer.parseInt(st.nextToken());
    
    st = new StringTokenizer(br.readLine());
    
    int c = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int n0 = Integer.parseInt(st.nextToken());
    
    if(a1*n0 + a0 <= c*n0 && c-a1>=0) bw.write("1");
    else bw.write("0");
    

    bw.flush();
    bw.close();
    br.close();
}
}