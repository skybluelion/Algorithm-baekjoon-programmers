import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = t/300; i >= 0; i--) {
            for (int j = t/60; j >= 0; j--) {
                for(int k = t/10; k >= 0; k--) {
                    if (t == i * 300 + j * 60 + k * 10) {
                        sb.append(i + " " + j + " " + k + " ");
                        System.out.print(sb.toString());
                        return;
                    }
                }
            }
        }
        System.out.print(-1);
        br.close();
    }
}