import java.util.*;

public class Prims 
{
    public static List<Route> findMST(List<Node> nodes, Map<String, Route> edges)
    {
        List<Route> result = new ArrayList<>();
        Set<Character> visited = new HashSet<>();
        PriorityQueue<Route> priority = new PriorityQueue<>();

        Node current = nodes.get(0);
        visited.add(current.name);

        for (Node to : nodes)
        {
            if (to.name == current.name)
            {
                continue;
            }
            Route r = edges.get(Route.key(current, to));
            priority.add(r);
        }

        while (!priority.isEmpty())
        {
            Route r = priority.poll();
            Node to = r.end();

            if (visited.contains(to.name))
            {
                continue;
            }
            visited.add(to.name);
            Node to = r.end();

            for (Node n : nodes)
            {
                if (!visited.contains(n.name))
                {
                    Route nr = edges.get(edges.get(Route.key(to. n)));
                    if(nr != null)
                    {
                        priority.add(nr);
                    }
                }
            }
        }

        return result;
    }
}
