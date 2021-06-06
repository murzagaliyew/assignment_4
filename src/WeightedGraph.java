import java.util.*;

public class WeightedGraph<V> {
    private final boolean undirected;
    private Set<Vertex<V>> set = new HashSet<>();

    public WeightedGraph() {
        undirected = false;
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex<V> vertex) {
        set.add(vertex);
    }

    private void addEdgePrivate(Vertex<V> source, Vertex<V> destination, double weight) {
        set.add(source);
        for (Vertex<V> vertex : set) {
            if (vertex.equals(source)) {
                vertex.addAdjacentVertex(destination, weight);
            }
        }
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        addEdgePrivate(source, destination, weight);
        if (undirected) {
            addEdgePrivate(destination, source, weight);
        }
    }

    public int getVerticesCount() {
        return set.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex<V> vertex : set) {
            count += vertex.getAdjacentVertices().size();
        }
        if (undirected) {
            count /= 2;
        }
        return count;
    }

    public boolean hasVertex(Vertex<V> vertex) {
        return set.contains(vertex);
    }

    public boolean hasEdge(Vertex<V> source, Vertex<V> dest) {
        if (set.contains(source) || set.contains(dest)) {
            for (Vertex<V> vertex : set) {
                if (vertex.getAdjacentVertices().containsKey(dest) || vertex.getAdjacentVertices().containsKey(source))
                    return true;
            }
        }
        return false;
    }

    public Iterable<Vertex<V>> adjacencyList(Vertex<V> vertex) {
        if (set.contains(vertex)) {
            List<Vertex<V>> vertices = new ArrayList<>();
            for (Vertex<V> v : set)
                if (v.equals(vertex))
                    vertices.addAll(v.getAdjacentVertices().keySet());
            return vertices;
        }
        return null;
    }

    public Set<Vertex<V>> getVertices() {
        return set;
    }
}
