import java.util.*;
 
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			int list[] = new int[3];
			list[0] = scanner.nextInt();
			list[1] = scanner.nextInt();
			list[2] = scanner.nextInt();
			Arrays.sort(list);
			if(list[0]==0 && list[1]==0 && list[2]==0) break;
			else if(list[0]*list[0] + list[1]*list[1] == list[2]*list[2]) {
				System.out.println("right");
			}
			else {
				System.out.println("wrong");
			}
		}
	}
}