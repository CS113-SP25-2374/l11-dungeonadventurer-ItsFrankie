public class Adventurer
{
    char[][] map;
    List<Node> pointsOfInterest = new ArrayList<>();
    //List<List<Node>> routes = new ArrayList<>();
    Map<String, Route> routes = new HashMap<>();

    public class Adventurer(char[][] map)
    {
        
    }

    public void solveMap(char[][] map)
    {
        this.map = map;
        findPOI();
        findPaths();
        findMST();
    }

    void findPOI()
    {
        for (int y=0; y < map.length; y++)
        {
            for (int x=0; x < map[y].length; x++)
            {
                char c = map[y][x];
                if(c == DungeonMap.WALL || c == DungeonMap.OPEN)
                {
                    continue;
                }
                pointsOfInterest.add(new Node(x,y,c));
            }
        }
    } // end of findPOI() method

    void findPaths()
    {
        for(int a=0; a < pointsOfInterest.size(); a++)
        {
            for(int b=0; b < pointsOfInterest.size(); b++)
            {
                List<Node> route;
                route = AStar.shortestPath(map, pointsOfInterest.get(a),pointsOfInterest.get(b));
                routes.add(route);
                Route r = new Route(route);
                routes.put(r.key(), r);
            }
        }
    } // end of findPaths() method

    void findMST()
    {
        List<Route> mst = Prims.findMST(pointsOfInterest, routes);
        System.out.println(mst);
    }
}