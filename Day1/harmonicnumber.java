import java.util.Scanner;

public class HarmonicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the harmonic value N: ");
        int N = sc.nextInt();
        if (N <= 0) {
            System.out.println("N must be greater than 0.");
            return;
        }
        double harmonic = 0.0;
        for (int i = 1; i <= N; i++) {
            harmonic += 1.0 / i;
        }
        System.out.println("The " + N + "th Harmonic value is: " + harmonic);
    }
}
