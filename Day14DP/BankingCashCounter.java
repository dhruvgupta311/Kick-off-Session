import java.util.*;

class Customer {
    String name;
    double amount;
    boolean isDeposit;

    public Customer(String name, double amount, boolean isDeposit) {
        this.name = name;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }
}

class Queue<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) return null;
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

public class BankingCashCounter {
    public static void main(String[] args) {
        Queue<Customer> queue = new Queue<>();
        double cashBalance = 1000;

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();
            System.out.print("Deposit (true/false): ");
            boolean isDeposit = sc.nextBoolean();
            sc.nextLine(); // consume newline

            Customer customer = new Customer(name, amount, isDeposit);
            queue.enqueue(customer);

            Customer currentCustomer = queue.dequeue();
            if (currentCustomer.isDeposit) {
                cashBalance += currentCustomer.amount;
                System.out.println("Deposited: " + currentCustomer.amount);
            } else {
                if (cashBalance >= currentCustomer.amount) {
                    cashBalance -= currentCustomer.amount;
                    System.out.println("Withdrawn: " + currentCustomer.amount);
                } else {
                    System.out.println("Insufficient balance.");
                }
            }
            System.out.println("Current Balance: " + cashBalance);
        }
    }
}
