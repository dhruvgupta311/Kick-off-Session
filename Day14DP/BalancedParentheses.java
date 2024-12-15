import java.util.*;

class Stack<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void push(T item) {
        list.addFirst(item);
    }

    public T pop() {
        if (isEmpty()) return null;
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

public class BalancedParentheses {
    public static boolean checkBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char c : expr.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expr = "(5+6)*(7+8)/(4+3)";
        System.out.println(checkBalanced(expr) ? "Balanced" : "Not Balanced");
    }
}
