import java.util.*;

public class Search<V> {
    protected int count;
    protected Set<Vertex<V>> marked;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;
    protected final Vertex<V> source;

    public Search(Vertex<V> source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<V> v) {
        return marked.contains(v);
    }

    public Iterable<Vertex<V>> pathTo(Vertex<V> v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Vertex<V>> linkedList = new LinkedList<>();
        for (Vertex<V> i = v; i != source; i = edgeTo.get(i)) {
            linkedList.push(i);
        }
        linkedList.push(source);

        return linkedList;
    }

    public int getCount() {
        return count;
    }
}