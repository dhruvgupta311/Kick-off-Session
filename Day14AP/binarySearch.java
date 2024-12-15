import java.io.*;
import java.util.*;

public class binarySearch {
    public static boolean binarySearch(List<String> words, String target) {
        int left = 0, right = words.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = words.get(mid).compareTo(target);
            if (comparison == 0) return true;
            if (comparison < 0) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:/Kick off Session/Day14AP/words.txt"));
        List<String> words = Arrays.asList(br.readLine().split(","));
        Collections.sort(words);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word to search: ");
        String word = sc.nextLine();
        System.out.println(binarySearch(words, word) ? "Word found" : "Word not found");
    }
}
