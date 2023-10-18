// to find bridge in graph by using tarjan's Algo

import java.util.ArrayList;

public class exp9 {
    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void create(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // for 0 vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        // for 1 vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        // for 2 vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        // for 3 vertex
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));

    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, int dt[], int low[], boolean visited[], int time){
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            // case 1
            if(neigh == par){
                continue;
            }
            
            //case 2
            else if(!visited[neigh]){
                dfs(graph, neigh, curr, dt, low, visited, time);

                // update low
                low[curr] = Math.min(low[curr], low[neigh]);
                
                // checking bridge condition
                if(dt[curr] < low[neigh]){
                    System.out.println("Bridge: " + curr + " -------- " + neigh);
                }
            }

            // case 3
            else{
                //update low
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }
    public static void tarjanAlgo(ArrayList<Edge>[] graph, int V){   //TC:- O(V + E)
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean visited[] = new boolean[V];
        int time = 0;

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(graph, i, -1, dt, low, visited, time);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        create(graph);
        tarjanAlgo(graph, V);
    }
}
