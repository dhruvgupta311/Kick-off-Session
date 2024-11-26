import java.util.Scanner;

public class ThreeSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of integers (N): ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.println("Distinct triplets that sum to zero are:");
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        System.out.println("(" + arr[i] + ", " + arr[j] + ", " + arr[k] + ")");
                        count++;
                    }
                }
            }
        }
        System.out.println("Total number of triplets: " + count);
        scanner.close();
    }
}
