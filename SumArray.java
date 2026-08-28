import java.util.Scanner;

public class SumArray {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }

        System.out.println(sum);
        in.close();
    }
}
