

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Reversing {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

        Node headOfReverse = reverse(head);

        while (headOfReverse != null) {
            System.out.println(headOfReverse.data);
            headOfReverse = headOfReverse.next;
        }

    }

    static Node reverse(Node head) {

        Node curr = head;
        Node prev = null;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}