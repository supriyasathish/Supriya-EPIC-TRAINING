import java.util.Scanner;

public class InverseMatrix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] a = new double[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = sc.nextDouble();
            }
        }

        double determinant = (a[0][0] * a[1][1])
                           - (a[0][1] * a[1][0]);

        if (determinant == 0) {
            System.out.println("Inverse does not exist");
        } else {

            System.out.println("Inverse:");

            System.out.println(
                a[1][1] / determinant + " " +
                (-a[0][1]) / determinant
            );

            System.out.println(
                (-a[1][0]) / determinant + " " +
                a[0][0] / determinant
            );
        }

        sc.close();
    }
}
