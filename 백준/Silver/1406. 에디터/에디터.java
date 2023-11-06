import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> leftText = new Stack<>();
        Stack<Character> rightText = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            leftText.push(str.charAt(i));
        }

        int N  = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String str2 = br.readLine();
            switch (str2.charAt(0)){
                case 'L':
                    if(leftText.empty()) break;
                    rightText.push(leftText.pop());
                    break;
                case 'D':
                    if(rightText.empty()) break;
                    leftText.push(rightText.pop());
                    break;
                case 'B':
                    if(leftText.empty()) break;
                    leftText.pop();
                    break;
                case 'P':
                    leftText.push(str2.charAt(2));
                    break;
            }
        }
        while(!leftText.empty()){
            rightText.push(leftText.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!rightText.empty()){
            sb.append(rightText.pop());
        }
        System.out.println(sb.toString());
    }
}

