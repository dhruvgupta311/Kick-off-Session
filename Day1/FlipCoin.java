import java.util.Scanner;

public class FlipCoin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of times to flip the coin: ");
        int flips = sc.nextInt();
        if (flips <= 0) {
            System.out.println("Enter a positive integer.");
            return;
        }

        int heads = 0;
        for (int i = 0; i < flips; i++) {
            if (Math.random() < 0.5) {
                heads++;
            }
        }

        int tails = flips - heads;
        System.out.printf("Heads: %.2f%%\n", (heads * 100.0) / flips);
        System.out.printf("Tails: %.2f%%\n", (tails * 100.0) / flips);
    }
}
