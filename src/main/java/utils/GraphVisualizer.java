package utils;

import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.layout.mxOrganicLayout;
import com.mxgraph.model.mxICell;
import com.mxgraph.util.mxCellRenderer;
import graph.CommunityGraph;
import graph.CommunityVertex;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.HashMap;
import java.util.Set;

public class GraphVisualizer implements IGraphVisualizer {
    private final CommunityGraph communityGraph;
    private final JGraphXAdapter<CommunityVertex, DefaultEdge> graphAdapter;

    public GraphVisualizer(CommunityGraph communityGraph) {
        this.communityGraph = communityGraph;
        this.graphAdapter = new JGraphXAdapter<CommunityVertex, DefaultEdge>(communityGraph.getGraph());
    }

    /**
     * Generate image and draw graph on it
     * @throws IOException
     */
    public void visualize() throws IOException {
        mxIGraphLayout layout = new mxOrganicLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());

        // If there are clusters found
        // Before depicting the graph on the image, set clusters vertices colors
        if (!communityGraph.getClusters().isEmpty()) {
            setVerticesColor();
        }

        BufferedImage image = mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
        File imgFile = new File("graph.png");
        ImageIO.write(image, "PNG", imgFile);
    }

    /**
     * For each cluster group set random text
     */
    private void setVerticesColor() {
        HashMap<CommunityVertex, mxICell> vertexToCellMap = graphAdapter.getVertexToCellMap();
        List<Set<CommunityVertex>> clusters = communityGraph.getClusters();

        for (Set<CommunityVertex> cluster : clusters) {
            Object[] vertexCellArray = new Object[cluster.size()];
            String clusterColor = RandomColor.nextColor();
            int i = 0;
            for (CommunityVertex vertex : cluster) {
                vertexCellArray[i++] = (Object) (vertexToCellMap.get(vertex));
            }
            graphAdapter.setCellStyle("fillColor=" + clusterColor, vertexCellArray);
        }

    }
}
