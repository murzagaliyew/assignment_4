import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private final V data;
    private final Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        adjacentVertices = new HashMap<>();
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        if (!data.equals(destination.getData()))
            adjacentVertices.put(destination, weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return data.equals(vertex.data);
    }

    public V getData() {
        return data;
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
}
