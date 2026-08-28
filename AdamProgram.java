import java.util.Scanner;

public class AdamProgram {

    static int reverse(int n) {
        int rev = 0;

        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n = n / 10;
        }

        return rev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int square = n * n;
        int reverseNumber = reverse(n);
        int reverseSquare = reverse(square);
        int squareOfReverse = reverseNumber * reverseNumber;

        if (reverseSquare == squareOfReverse) {
            System.out.println("Adam Number");
        } else {
            System.out.println("Not an Adam Number");
        }
        sc.close();
    }
}
