import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int five = n / 5;
        int three = 0;
        while(true) {
            if (five == 0){
                if(0 == n % 3){
                    three = n / 3;
                    System.out.println(three);
                    break;
                }else {
                    System.out.println(-1);
                    break;
                }
            }

            if(0 == (n - five * 5) % 3){
                three = (n - five * 5) / 3;
                System.out.println(five + three);
                break;
            }
            five --;
        }
        br.close();
    }
}