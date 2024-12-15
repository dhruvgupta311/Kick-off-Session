import java.util.*;

public class PrimeAnagramQueue {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean areAnagrams(int num1, int num2) {
        char[] arr1 = String.valueOf(num1).toCharArray();
        char[] arr2 = String.valueOf(num2).toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= 1000; i++) {
            if (isPrime(i)) {
                for (int j = i + 1; j <= 1000; j++) {
                    if (isPrime(j) && areAnagrams(i, j)) {
                        queue.add(i);
                        queue.add(j);
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
