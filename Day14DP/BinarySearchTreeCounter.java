import java.util.*;

public class BinarySearchTreeCounter{
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases
        int[] testCases = new int[T];
        int maxN = 0;

        // Reading input and finding the maximum N for precomputing
        for(int i=0;i<T;i++){
            testCases[i]=sc.nextInt();
            maxN=Math.max(maxN, testCases[i]);
        }

        // Precompute the Catalan numbers up to maxN
        long[] catalan = new long[maxN + 1];
        catalan[0] = 1; // Base case: C(0) = 1

        for (int n = 1; n <= maxN; n++){
            catalan[n] = 0;
            for (int i = 0; i < n; i++) {
                catalan[n] = (catalan[n] + (catalan[i] * catalan[n - 1 - i]) % MOD) % MOD;
            }
        }
        // Output results for each test case
        for(int n : testCases) {
            System.out.println(catalan[n]);
        }
        sc.close();
    }
}
