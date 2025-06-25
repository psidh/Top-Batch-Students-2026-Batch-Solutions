
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class LoopDetection {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node head2 = new Node(2);
        Node head3 = new Node(3);
        head.next = head2;
        head2.next = head3;
        head3.next = null;

        // there's a cycle in here now we need to detect it here

        Node slow = head;
        Node fast = head;
        boolean flag = true;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.err.println("Found it goddammit");
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println("Nothing in here");
    }
}
