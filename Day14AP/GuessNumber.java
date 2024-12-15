import java.util.*;

public class GuessNumber {
    public static int guessNumber(int low, int high, int n) {
        if (low >= high) return low;
        int mid = (low + high) / 2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Is your number between " + low + " and " + mid + "? (yes/no)");
        String response = sc.next();
        if (response.equals("yes")) return guessNumber(low, mid, n);
        else return guessNumber(mid + 1, high, n);
    }

    public static void main(String[] args) {
        int N = 16; // Example N value, should be a power of 2
        int result = guessNumber(0, N - 1, N);
        System.out.println("Your number is: " + result);
    }
}
