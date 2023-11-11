
class Graph {
    private int[][] adjDistance;
    private int n;
    public Graph(int n, int[][] edges) {
        this.adjDistance = new int[n][n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            Arrays.fill(adjDistance[i], (int)1e9);
            adjDistance[i][i] = 0;
        }
        for (int[] e : edges) {
            adjDistance[e[0]][e[1]] = e[2];
        }
        for (int i = 0; i < n; i++) {
            updateDist(i, i);
        }
    }

    public void addEdge(int[] edge) {
        if (edge[2] >= adjDistance[edge[0]][edge[1]]) {
            return;
        }
        adjDistance[edge[0]][edge[1]] = edge[2];
        updateDist(edge[0], edge[1]);
    }
    
    public int shortestPath(int node1, int node2) {
        return adjDistance[node1][node2] == (int) 1e9 ? -1 : adjDistance[node1][node2];
    }

    private void updateDist(int node1, int node2) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjDistance[i][j] = Math.min(adjDistance[i][j], 
                adjDistance[i][node1] + adjDistance[node2][j] + adjDistance[node1][node2]);
            }
        }
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */