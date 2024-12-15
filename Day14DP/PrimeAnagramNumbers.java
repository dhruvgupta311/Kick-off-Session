import java.util.*;

public class PrimeAnagramNumbers {
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
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }

        List<List<Integer>> anagramGroups = new ArrayList<>();
        for (int i = 0; i < primeNumbers.size(); i++) {
            List<Integer> group = new ArrayList<>();
            for (int j = i + 1; j < primeNumbers.size(); j++) {
                if (areAnagrams(primeNumbers.get(i), primeNumbers.get(j))) {
                    group.add(primeNumbers.get(i));
                    group.add(primeNumbers.get(j));
                }
            }
            if (!group.isEmpty()) {
                anagramGroups.add(group);
            }
        }

        for (List<Integer> group : anagramGroups) {
            System.out.println(group);
        }
    }
}
