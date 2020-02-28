package withgoogle.y2019.a;

import java.util.Arrays;
import java.util.Scanner;

public class Training {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int P = scanner.nextInt();
            int[] ranks = new int[N];
            for(int r = 0; r < N; r++) {
                ranks[r] = scanner.nextInt();
            }
            System.out.println("Case #" + t + ": " + calcHours(ranks, P));
        }
    }

    private static int calcHours(int[] ranks, int P) {
        Arrays.sort(ranks);
        int hours = 0;
        for(int i = 1; i < P; i++) {
            hours +=  i * (ranks[i] - ranks[i - 1]);
        }
        int min = hours;
        for(int i = P; i < ranks.length; i++) {
            hours -= (ranks[i - 1] - ranks[i - P]);
            hours += (P - 1) * (ranks[i] - ranks[i - 1]);
            if(hours == 0) return 0;
            min = Math.min(min, hours);
        }
        return min;
    }
}