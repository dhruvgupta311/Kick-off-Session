import java.util.Scanner;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;

public class TwoDArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of rows (M): ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns (N): ");
        int cols = scanner.nextInt();
        
        int[][] array = new int[rows][cols];
        
        System.out.println("Enter elements row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        writer.println("The 2D Array is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                writer.print(array[i][j] + " ");
            }
            writer.println();
        }
        writer.flush();
        scanner.close();
    }
}
