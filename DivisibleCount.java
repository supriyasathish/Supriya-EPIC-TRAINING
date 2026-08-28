import java.util.Scanner;

public class DivisibleCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int divisor = sc.nextInt();

        int count = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (num % divisor == 0) {
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
