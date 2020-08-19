package graph;

import java.awt.*;

public class CommunityVertex {
    private String name;
    private Color color;

    public CommunityVertex(String name) {
        this.name = name;
    }

    public CommunityVertex() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return name;
    }

    public int hashCode()
    {
        return toString().hashCode();
    }

    public boolean equals(Object o)
    {
        return (o instanceof CommunityVertex) && (toString().equals(o.toString()));
    }
}
