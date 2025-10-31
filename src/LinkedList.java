public class LinkedList {
    Node head;

    // a node has a value and a pointer to the next element
    class Node {
        int val;
        Node next;
        // creates a new node (constructor)
        Node (int val) {
            this.val = val;
        }
    }

    // creates a new list (constructor)
    LinkedList(int val) {
        head = new Node(val);
    }

    void add(int val) {
        Node node = new Node(val);

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
       // insert here
       current.next = node;
    }

    void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.val);
            // move to the next element
            current = current.next;
        }
    }

    boolean contains(int val) {
        Node current = head;
        while (current != null) {
            if (current.val == val) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    void remove(int val) {

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.add(2);
        list.add(3);
        list.add(0);
        list.add(9);
        list.print();
        System.out.println(list.contains(3)); // true
        System.out.println(list.contains(10)); // false
    }
}
