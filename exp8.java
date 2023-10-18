// cycle detection in undirected graph

import java.util.ArrayList;
public class exp8 {
    public static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
       for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
       }

       graph[0].add(new Edge(0, 1, 1));
       graph[0].add(new Edge(0, 5, 1));

       graph[1].add(new Edge(1, 0, 1));
       graph[1].add(new Edge(1, 2, 1));

       graph[2].add(new Edge(2, 1, 1));
       graph[2].add(new Edge(2, 3, 1));

       graph[3].add(new Edge(3, 2, 1));
       graph[3].add(new Edge(3, 4, 1));

       graph[4].add(new Edge(4, 3, 1));
       graph[4].add(new Edge(4, 5, 1));

       graph[5].add(new Edge(5, 0, 1));
       graph[5].add(new Edge(5, 4, 1));
       graph[5].add(new Edge(5, 6, 1));
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                dfs(graph, visited, i, -1);
                return true;
            }
        }
        return false;
    }

    public static boolean dfs(ArrayList<Edge>[] graph, boolean visited[], int curr, int parent){
        visited[curr] = true;

        for(int i = 0; i <  graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!visited[e.dest]){
                if(dfs(graph, visited, e.dest, curr)){
                    return true;
                }
            }
            else if(visited[e.dest] && e.dest != parent){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    
    }
}
