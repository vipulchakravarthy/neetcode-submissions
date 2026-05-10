class Solution {
    public int countComponents(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(graph, i, visited);
                count++;
            }
        }

        return count;
    }

    private void dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited) {
        visited[src] = true;

        for(int neighbour: graph.get(src)) {
            if(!visited[neighbour]) {
                dfs(graph, neighbour, visited);
            }
        }
    }
}
