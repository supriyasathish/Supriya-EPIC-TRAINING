import java.util.Scanner;

public class ZeroReduce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 0;
        int place = 1;

        while (n != 0) {
            int digit = n % 10;

            if (digit != 0) {
                result = result + digit * place;
                place = place * 10;
            }

            n = n / 10;
        }

        System.out.println(result);
        sc.close();
    }
}
