public class Node implements Comparable<Node>
{
    int x;
    int y;
    char name;
    int g;
    int h;
    public Node parent;

    public Node(int x, int y, char name)
    {
        this.x = x
        this.y = y;
        this.name = name
    }

    public Node(int x, int y, char name, int g, int h)
    {
        this(x, y, name);
        this.g = g;
        this.h = h;
    }

    public Node(int x, int y, char name, int g, int h, Node parent)
    {
        this(x, y, name, g, h);
        this.parent = parent;
    }

    public Node(Node node)
    {
        this.x = node.x;
        this.y = node.y;
        this.g = node.g;
        this.h = node.h;
        this.name = node.name;
    }

    @Override
    public int compareTo(Node o)
    {
        return Integer.compare(this.f(), o.f());
    }
}