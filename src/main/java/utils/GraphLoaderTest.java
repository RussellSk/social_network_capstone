package utils;

import graph.CommunityVertex;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class GraphLoaderTest implements IGraphLoader {
    @Override
    public Graph<CommunityVertex, DefaultEdge> load() {
        Graph<CommunityVertex, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        CommunityVertex v1 = new CommunityVertex("v1");
        CommunityVertex v2 = new CommunityVertex("v2");
        CommunityVertex v3 = new CommunityVertex("v3");
        CommunityVertex v4 = new CommunityVertex("v4");
        CommunityVertex v5 = new CommunityVertex("v5");
        CommunityVertex v6 = new CommunityVertex("v6");
        CommunityVertex v7 = new CommunityVertex("v7");
        CommunityVertex v8 = new CommunityVertex("v8");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addEdge(v1, v2);
        graph.addEdge(v1, v3);
        graph.addEdge(v1, v4);

        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addVertex(v7);
        graph.addVertex(v8);
        graph.addEdge(v5, v6);
        graph.addEdge(v5, v7);
        graph.addEdge(v5, v8);
        graph.addEdge(v5, v1);

        return graph;
    }
}
