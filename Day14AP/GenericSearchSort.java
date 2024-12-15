import java.util.*;

public class GenericSearchSort {
    public static <T extends Comparable<T>> boolean binarySearch(List<T> list, T target) {
        Collections.sort(list);
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = list.get(mid).compareTo(target);
            if (comparison == 0) return true;
            if (comparison < 0) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static <T extends Comparable<T>> void insertionSort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "grape");
        System.out.println("Binary Search result: " + binarySearch(words, "banana"));
        insertionSort(words);
        System.out.println("Sorted List: " + words);
    }
}
