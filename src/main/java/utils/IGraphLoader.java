package utils;

import graph.CommunityVertex;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public interface IGraphLoader {
    public Graph<CommunityVertex, DefaultEdge> load();
}
