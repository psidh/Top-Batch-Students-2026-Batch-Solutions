import java.util.Stack;

public class CustomQueue {
    private Stack<Integer> left = new Stack<>();
    private Stack<Integer> right = new Stack<>();

    public void insert(int data) {
        left.push(data);
    }

    public int remove() {
        if (right.isEmpty()) {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
        }
        if (right.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return right.pop();
    }

    public int peek() {
        if (right.isEmpty()) {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
        }
        if (right.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return right.peek();
    }

    public static void main(String[] args) {
        CustomQueue q = new CustomQueue();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        System.out.println(q.remove()); // 1
        System.out.println(q.remove()); // 2
        q.insert(4);
        System.out.println(q.remove()); // 3
    }
}
