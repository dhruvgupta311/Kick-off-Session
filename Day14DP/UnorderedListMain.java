import java.io.*;
import java.util.*;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class UnorderedList<T> {
    private Node<T> head;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    public boolean search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) return true;
            current = current.next;
        }
        return false;
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

public class UnorderedListMain {
    public static void main(String[] args) throws IOException {
        UnorderedList<String> list = new UnorderedList<>();
        BufferedReader br = new BufferedReader(new FileReader("words.txt"));
        String[] words = br.readLine().split(" ");
        for (String word : words) {
            list.add(word);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word to search: ");
        String word = sc.nextLine();

        if (list.search(word)) {
            list.remove(word);
            System.out.println("Word removed.");
        } else {
            list.add(word);
            System.out.println("Word added.");
        }

        list.saveToFile("words.txt");
    }
}
