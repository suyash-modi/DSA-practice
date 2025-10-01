// https://www.geeksforgeeks.org/problems/topological-sort/1

class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indeg = new int[V];
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            indeg[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int neighbor : adj.get(node)) {
                indeg[neighbor]--;
                if (indeg[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        if (topo.size() != V) {
            return new ArrayList<>(); // return empty if there is a cycle
        }

        return topo;
    }
}
