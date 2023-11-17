import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = arr[0];
        pq.add(sum);
        for(int i = 1; i < n; i++) {
            if (sum + arr[i] <= 0) {
                sum = 0;
                pq.add(arr[i]);
            } else {
                sum += arr[i];
                pq.add(sum);
            }
        }    
        System.out.print(pq.peek());
    }
}