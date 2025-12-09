/*
A -> [B,C,D]
B -> [A,E,F]
C -> [A,D,G]
...

*/
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Graph {
    class Node {
        int val;
        List<Node> adjacents; // default is null
        Node(int val) {
            this.val = val;
            adjacents = new ArrayList<>(); // empty
        }
    }

    Map<Integer, Node> children;
    Map<Integer, Integer> indegree;
    Map<Integer, Integer> outdegree;

    Graph(int n) {
        children = new HashMap<>();	// {}

        indegree = new HashMap<>();
        outdegree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indegree.put(i, 0);
            outdegree.put(i, 0);
        }
    }

    /*
    0->1
    0->2
    0->3
    */
    public void addEdge(int source, int dest) { // 0, 2
        Node s = getNode(source); // 0
        Node d = getNode(dest);		// 2

        s.adjacents.add(d); // 0->{1,2,3}
        // d.adjacents.add(s); // undirected

        indegree.put(dest, indegree.get(dest) + 1);
        outdegree.put(source, outdegree.get(source) + 1);
    }

    Node getNode(int val) {
        // returns null if there is no key (val)
        Node node = children.get(val); // 0
        if (node == null) {	// null, null
            node = new Node(val);
            children.put(val, node);	// {0, node(0)}, {1, node(1)}, {2, node(2)}
        }
        return node;
    }

    // determine if there is a path between a source and a destination
    boolean hasPath(int source, int dest) {
        Node s = getNode(source);
        Node d = getNode(dest);
        return hasPath(s, d, new ArrayList<>());
    }

    // DFS
    boolean hasPath(Node source, Node dest, List<Integer> visited) {
        // if already visited, skip
        if (visited.contains(source.val)) {
            return false;
        }

        // stop condition
        if (source == dest) {
            return true;
        }

        visited.add(source.val);

        // go towards the stop condition
        // recurse
        for (Node adjacent: source.adjacents) {
            if (hasPath(adjacent, dest, visited)) {
                return true;
            }
        }

        return false;
    }

    // BFS (queue based)
    boolean hasPathBfs(int source, int dest) {
        Node s = getNode(source);
        Node d = getNode(dest);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(s);


        List<Integer> visited = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == d) {
                return true;
            }

            if (visited.contains(current.val)) {
                continue;
            }
            visited.add(current.val);

            for(Node adjacent: current.adjacents) {
                queue.offer(adjacent);
            }
        }

        return false;
    }


    static void main() {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);

        System.out.println(graph.hasPath(2, 4)); // true
        System.out.println(graph.hasPath(3, 0)); // false (directed), true (undirected)
        // System.out.println(graph.hasPathBfs(2, 4)); // true
        // System.out.println(graph.hasPathBfs(3, 0)); // false (directed), true (undirected)
        System.out.println("indegree=" + graph.indegree);
        System.out.println("outdegree=" + graph.outdegree);
    }
}