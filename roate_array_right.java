

import java.util.Scanner;

public class roate_array_right {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] arr = new int[n];

        int rot = in.nextInt();

        for (int i = 0; i < n; i++) {
            arr[(i + rot) % n] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        in.close();
    }
}