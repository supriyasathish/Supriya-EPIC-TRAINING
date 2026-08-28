import java.util.Scanner;

public class DuplicateMissing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int duplicate = -1;
        int missing = -1;

        for (int i = 1; i <= n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    count++;
                }
            }

            if (count == 0) {
                missing = i;
            } else if (count == 2) {
                duplicate = i;
            }
        }

        System.out.println("Duplicate = " + duplicate);
        System.out.println("Missing = " + missing);
        sc.close();
    }
}
