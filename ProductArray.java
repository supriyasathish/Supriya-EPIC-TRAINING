import java.util.Scanner;

public class ProductArray {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int product = 1;

        for (int i = 0; i < n; i++) {
            product = product * arr[i];
        }

        System.out.println(product);
        in.close();
    }
}
