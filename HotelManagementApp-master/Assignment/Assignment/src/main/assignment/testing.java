package assignment;
import java.util.Scanner;

public class testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hi = scanner.nextInt();
        if (hi > 3){
            System.out.println("hello");
        }
        scanner.close();
    }
}
