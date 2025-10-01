
// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
         ArrayList<Integer> ans=new ArrayList<>();
        
        boolean vis[]=new boolean[V];
        
        for(int i=0;i<V;i++)
        {
            if(!vis[i] &&  dfs(adj,vis,ans,i,-1))
            {
                return true;
            }
        }
        
        return false;
         
         
    }
    private static boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],ArrayList<Integer> ans,int u,int p)
    {
        
        
        vis[u]=true;
        ans.add(u);
        
        for(int v: adj.get(u))
        {
            if(v==p) continue;
            
            if(vis[v]) return true;
           
           if(dfs(adj,vis,ans,v,u))
           {
               return true;
           }
        }
        return false;
    }
}
