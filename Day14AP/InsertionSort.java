import java.util.*;

public class InsertionSort {
    public static void sort(String[] words) {
        for (int i = 1; i < words.length; i++) {
            String key = words[i];
            int j = i - 1;
            while (j >= 0 && words[j].compareTo(key) > 0) {
                words[j + 1] = words[j];
                j--;
            }
            words[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "banana", "grape"};
        sort(words);
        System.out.println(Arrays.toString(words));
    }
}
