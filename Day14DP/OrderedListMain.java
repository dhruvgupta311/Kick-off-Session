import java.io.*;
import java.util.*;

class OrderedList<T extends Comparable<T>> {
    private Node<T> head;

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null || head.data.compareTo(data) >= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null && current.next.data.compareTo(data) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void remove(T data) {
        if (head == null) return;

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public boolean search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) return true;
            current = current.next;
        }
        return false;
    }

    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        Node<T> current = head;
        while (current != null) {
            writer.write(current.data + " ");
            current = current.next;
        }
        writer.close();
    }
}

public class OrderedListMain {
    public static void main(String[] args) throws IOException {
        OrderedList<Integer> list = new OrderedList<>();
        BufferedReader br = new BufferedReader(new FileReader("numbers.txt"));
        String[] numbers = br.readLine().split(" ");
        for (String num : numbers) {
            list.insert(Integer.parseInt(num));
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (list.search(num)) {
            list.remove(num);
            System.out.println("Number removed.");
        } else {
            list.insert(num);
            System.out.println("Number added.");
        }

        list.saveToFile("numbers.txt");
    }
}
