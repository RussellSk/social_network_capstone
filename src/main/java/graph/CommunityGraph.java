package graph;

import org.jgrapht.*;
import org.jgrapht.alg.clustering.LabelPropagationClustering;
import org.jgrapht.alg.interfaces.ClusteringAlgorithm;
import org.jgrapht.graph.*;
import utils.IGraphLoader;
import utils.IGraphVisualizer;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class CommunityGraph {
    private final Graph<CommunityVertex, DefaultEdge> graph;
    private List<Set<CommunityVertex>> clusters;

    public CommunityGraph() {
        graph = new DefaultDirectedGraph<>(DefaultEdge.class);
    }

    public CommunityGraph(IGraphLoader loader) {
        this.graph = loader.load();
    }

    public Graph<CommunityVertex, DefaultEdge> getGraph() {
        return graph;
    }

    public List<Set<CommunityVertex>> getClusters() {
        return clusters;
    }

    /**
     * Detecting communities in current graph
     * For detecting communities function uses Label Propagation Clustering
     * @return int number of clusters found
     */
    public int detectCommunities() {
        ClusteringAlgorithm<CommunityVertex> clusteringAlgorithm = new LabelPropagationClustering<>(graph);
        ClusteringAlgorithm.Clustering<CommunityVertex> clustering = clusteringAlgorithm.getClustering();
        clusters = clustering.getClusters();
        System.out.println(clustering);

        return clustering.getNumberClusters();
    }

    /**
     * Visualize Graph
     * Function draw graph on the image graph.png and then save it on disk
     * @throws IOException
     */
    public void visualizeGraph(IGraphVisualizer visualizer) throws IOException {
        // todo something before visualize graph
        visualizer.visualize();
    }
}
