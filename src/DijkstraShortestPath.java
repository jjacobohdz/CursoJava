import java.util.*;

class DijkstraShortestPath {

    /*
    edge=parent(0),child(1),weight(2)
    */
    class Edge {
        int val;
        int weight;
        Edge(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
    }

    class Distance {
        int distance;
        int previous;
        Distance(int distance, int previous) {
            this.distance = distance;
            this.previous = previous;
        }
    }

    private static final int NONE = -1;

    // returns the shortest distance from a source to a destination
    public int shortestPath(int[][] edges, int n, int source, int dest) {
        // distances are 1 based (instead of 0 based)
        Distance[] distances = new Distance[n + 1];
        // init with positive infinite
        for (int i = 0; i < distances.length; i++){
            distances[i] = new Distance(Integer.MAX_VALUE, NONE);
        }
        // source node has a distance of 0
        distances[source] = new Distance(0, NONE);

        // form our graph from the given adjacency matrix
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 1; i <=n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            int parent = edge[0];
            int child = edge[1];
            int weight = edge[2];

            // directed
            graph.get(parent).add(new Edge(child, weight));
            // undirected
            graph.get(child).add(new Edge(parent, weight));
        }

        // bfs (Dijkstra's algo)
        // use a min heap to keep the edge with less weight at the root
        PriorityQueue<Edge> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        queue.offer(new Edge(source, 0));

        List<Integer> visited = new ArrayList<>();

        while(!queue.isEmpty()) {
            Edge current = queue.poll(); // always dequeue the minimum weight edge
            // skip visited edges
            if (visited.contains(current.val)) {
                continue;
            }

            // visit its adjacents
            for (Edge adjacent: graph.get(current.val)) {
                // relaxation
                // is parent's distance + edge's distance < adjacent's distance?, if so, update adjacent's distance
                int newDistance = distances[current.val].distance + adjacent.weight;
                if (newDistance < distances[adjacent.val].distance) {
                    distances[adjacent.val].distance = newDistance;
                    distances[adjacent.val].previous = current.val;
                    // greedy
                    queue.offer(new Edge(adjacent.val, newDistance));
                }
            }

            visited.add(current.val);
        }

        printPath(distances, dest);

        return distances[dest].distance;
    }

    void printPath(Distance[] distances, int dest) {
        if (distances[dest].previous == NONE) {
            return;
        }
        printPath(distances, distances[dest].previous);
        System.out.println(distances[dest].previous);
    }

    static void main() {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath();
        int[][] edges = {{1,2,3},{2,3,1},{3,4,4},{1,4,9}};
        int res = dijkstraShortestPath.shortestPath(edges, 4, 2, 4);
        System.out.println(res); // 8
    }
}















