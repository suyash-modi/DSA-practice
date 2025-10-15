// https://leetcode.com/problems/is-graph-bipartite/

class Solution {
    boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int c,int[] color) {
        color[node] = c;
        for(int item:adj.get(node)) {
            if(color[item]==-1) {
                if(dfs(adj,item,1-c,color)==false) return false;
            }else if(color[item]==color[node]) {
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<graph[i].length;j++) {
                adj.get(i).add(graph[i][j]);
            }
        }
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++) {
            if(color[i]==-1) {
                if(!dfs(adj,i,0,color)) {
                    return false;
                }
            }
        }
        return true;
    }
}