
class Queue {
    class Node {
        int val;
        Node next; // default is null
        Node (int val) {
            this.val = val;
        }
    }

    Node head; // default is null
    Node tail; // default is null

    Queue() {}

    void enqueue(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
    }

    Integer dequeue() {
        if (head == null) {
            return null;
        }
        int val = head.val;

        head = head.next;
        if (head == null) {
            tail = null;
        }

        return val;
    }

    Integer peek() {
        if (head == null) {
            return null;
        }

        return head.val;
    }

    boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        System.out.println(queue.isEmpty()); // true

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.isEmpty()); // false

        System.out.println(queue.peek());    // 1
        System.out.println(queue.dequeue()); // 1

        System.out.println(queue.peek());    // 2
        System.out.println(queue.dequeue()); // 2

        System.out.println(queue.peek());    // 3
        System.out.println(queue.dequeue()); // 3
        System.out.println(queue.dequeue()); // null

        System.out.println(queue.isEmpty()); // true
    }

}




