package striver.graphs;

public class possible_graphs {

    //undirected graphs
    static int countUG(int vertices)
    {
        //possible edges
        int edges= vertices*(vertices-1)/2;
        return (int)Math.pow(2,edges);
    }
    //directed graphs
    static int countDG(int vertices)
    {
        //possible edges
        int edges = vertices*(vertices-1);
        return (int) Math.pow(2,edges);
    }
}
