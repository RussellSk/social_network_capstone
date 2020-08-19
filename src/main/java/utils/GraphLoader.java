package utils;

import graph.CommunityVertex;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphLoader implements IGraphLoader {
    private Scanner scanner;
    private int loadAmount = 0;

    public GraphLoader(String filename, int loadAmount) throws FileNotFoundException {
        scanner = new Scanner(new File(filename));
        this.loadAmount = loadAmount;
    }

    /**
     * Load graph from file data set
     * @return raph<CommunityVertex, DefaultEdge> loaded graph
     */
    @Override
    public Graph<CommunityVertex, DefaultEdge> load() {
        Graph<CommunityVertex, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        int count = 0;
        while (scanner.hasNextInt()) {

             CommunityVertex vertex1 = new CommunityVertex(String.valueOf(scanner.nextInt()));
             graph.addVertex(vertex1);


             CommunityVertex vertex2 = new CommunityVertex(String.valueOf(scanner.nextInt()));
             graph.addVertex(vertex2);


            if (!graph.containsEdge(vertex1, vertex2)) {
                graph.addEdge(vertex1, vertex2);
            }

            // Graph load limiter
            if (count++ > loadAmount) break;
        }

        scanner.close();

        return graph;
    }
}
