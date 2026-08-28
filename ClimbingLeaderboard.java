import java.util.*;

public class ClimbingLeaderboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] alice = new int[m];

        for (int i = 0; i < m; i++) {
            alice[i] = sc.nextInt();
        }

        // Remove duplicate scores
        ArrayList<Integer> unique = new ArrayList<>();

        for (int score : scores) {
            if (unique.size() == 0 || unique.get(unique.size() - 1) != score) {
                unique.add(score);
            }
        }

        for (int score : alice) {
            int low = 0;
            int high = unique.size() - 1;
            int rank = unique.size() + 1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (score >= unique.get(mid)) {
                    rank = mid + 1;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            System.out.println(rank);
            sc.close();
        }
    }
}
