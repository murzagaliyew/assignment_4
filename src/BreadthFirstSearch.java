import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V>{

    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(source);
        breadthFirstSearch(graph, source);
    }

    private void breadthFirstSearch(WeightedGraph<V> graph, Vertex<V> current) {
        marked.add(current);
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(current);
        while (!queue.isEmpty()) {
            Vertex<V> v = queue.remove();
            for (Vertex<V> vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }
}