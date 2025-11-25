import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }
    Node root;

    // constructor
    BinarySearchTree(int val) {
        root = new Node(val);
    }

    void add(int val) {
        add(root, val);
    }

    // if val < root, go left, if val > root, go right
    Node add(Node root, int val) {
        // stop condition
        if (root == null) {
            return new Node(val);
        }
        // move towards the stop condition
        // recurse
        if (val < root.val) {
            root.left = add(root.left, val);
        } else {
            root.right = add(root.right, val);
        }

        return root;
    }

    void inOrder() {
        inOrder(root);
    }

    /*
    recursively go deep into the left subtree
    visit the root
    recursively go deep into the right subtree
     */
    private void inOrder(Node root) {   // 10, 8, 2, 1, null
        // stop condition
        if (root == null) {
            return;
        }
        // move towards the stop condition
        // recurse
        inOrder(root.left); // 8, 2, 1, null
        System.out.println(root.val);
        inOrder(root.right);
    }

    void preOrder() {
        preOrder(root);
    }

    /*
    visit the root node
    recursively traverse the left subtree
    recursively traverse the right subtree
     */
    void preOrder(Node root) {
        // stop condition
        if (root == null) {
            return;
        }
        // move towards the stop condition
        // recurse
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    void postOrder() {
        postOrder(root);
    }

    /*
    recursively traverse the left subtree
    recursively traverse the right subtree
    visit the root node
     */
    void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    // searches the given value in the tree and returns true if it exists or false otherwise
    boolean contains(int val) {
        return contains(root, val);
    }

    boolean contains(Node root, int val) {
        // stop conditions: either root is null or we found the value
        if (root == null) {
            return false;
        }
        if (val == root.val) {
            return true;
        }
        // move towards stop condition
        // recurse
        if (val < root.val) {
            return contains(root.left, val);
        } else {
            return contains(root.right, val);
        }
    }

    void bfs() {
        // enqueue the root node
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        // repeat while the queue is not empty
        while (!queue.isEmpty()) {
            // dequeue
            Node current = queue.poll();
            // visit the current element
            System.out.print(current.val + ",");
            // add current element's children to the queue
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    static void main() {
        BinarySearchTree tree = new BinarySearchTree(10);
        tree.add(8); // goes to the left of 10
        tree.add(11); // goes to the right of 10
        tree.add(2);
        tree.add(1);
        tree.add(6);
        tree.add(4);
        tree.add(3);
        tree.add(5);
        tree.add(14);
        tree.add(13);
        tree.add(16);
        tree.bfs();
        // tree.preOrder(); // 10, 8, 2, 1, 6, 4, 3, 5, 11, 14, 13, 16
        // tree.postOrder(); // 1, 3, 5, 4, 6, 2, 8, 13, 16, 14, 11, 10
        // System.out.println(tree.contains(4)); // true
        // System.out.println(tree.contains(0)); // false
        // System.out.println(tree.contains(20)); // false
        // System.out.println(tree.contains(16)); // true
    }
}












