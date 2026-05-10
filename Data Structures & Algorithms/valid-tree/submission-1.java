class Solution {
    public boolean validTree(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // graph can be a tree iff there are no cycles in it and connected - only one cc
        // boils down to cycle detection in undirected graph
        Set<Integer> visited = new HashSet<>();
        if(isCyclic(graph, 0, visited, -1)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean isCyclic(ArrayList<ArrayList<Integer>> graph, int src, Set<Integer> visited, int parent) {
        visited.add(src);

        for(int neighbour: graph.get(src)) {
            if(!visited.contains(neighbour)) {
                if(isCyclic(graph, neighbour, visited, src)) {
                    return true;
                }
            } else if(neighbour != parent){
                return true;
            }
        }

        return false;
    }
}
