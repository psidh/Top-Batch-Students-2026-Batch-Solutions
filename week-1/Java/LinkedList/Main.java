
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        insert(2, head, 5);
        traverse(head);
        delete(head, 2);
        System.out.println();
        traverse(head);
        // 1->2->3
    }

    static Node insert(int beforeWhom, Node head, int value) {
        Node curr = head;
        while (!(curr.next.data == beforeWhom)) {
            curr = curr.next;
        }
        Node temp = new Node(value);
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    static void traverse(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
    }

    static Node delete(Node head, int toDelete) {
        Node curr = head;
        while (!(curr.next.data == toDelete)) {
            curr = curr.next;
        }
        Node temp = curr.next;
        curr.next = curr.next.next;
        return temp;
    }
}
