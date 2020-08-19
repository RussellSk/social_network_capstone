import graph.CommunityGraph;
import utils.GraphLoader;
import utils.GraphLoaderTest;
import utils.GraphVisualizer;

import java.io.IOException;

public class application {
    public static void main(String[] args) throws IOException {
        System.out.println("Capstone: Analyzing (Social) Network Data (Skaldin Ruslan)");

        // Create new graph and load Test data
        //CommunityGraph communityGraph = new CommunityGraph(new GraphLoaderTest());

        // Create new graph with Facebook data
        // LoadAmount parameter let us restrict load a whole file, because process of rendering graph to image
        // consume a lot of machine resources
        CommunityGraph communityGraph = new CommunityGraph(new GraphLoader("data/socfb-American75.mtx", 200));

        int communities = communityGraph.detectCommunities();
        System.out.println("Communities found: " + communities);

        communityGraph.visualizeGraph(new GraphVisualizer(communityGraph));
    }
}
