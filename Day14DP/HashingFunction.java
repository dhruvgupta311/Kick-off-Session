import java.io.*;
import java.util.*;

public class HashingFunction {
    static final int SIZE = 10;
    static LinkedList<Integer>[] slots = new LinkedList[SIZE];

    public static int hash(int num) {
        return num % SIZE;
    }

    public static void insert(int num) {
        int index = hash(num);
        if (slots[index] == null) {
            slots[index] = new LinkedList<>();
        }
        slots[index].add(num);
    }

    public static boolean search(int num) {
        int index = hash(num);
        if (slots[index] != null) {
            return slots[index].contains(num);
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Arrays.fill(slots, null);
        BufferedReader br = new BufferedReader(new FileReader("numbers.txt"));
        String[] numbers = br.readLine().split(" ");
        for (String num : numbers) {
            insert(Integer.parseInt(num));
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to search: ");
        int num = sc.nextInt();

        if (search(num)) {
            System.out.println("Number found.");
        } else {
            insert(num);
            System.out.println("Number added.");
        }
    }
}
