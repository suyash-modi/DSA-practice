// https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1



class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n=adj.size();
        boolean vis[]=new boolean[n];
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                dfs(ans,adj,n,vis,i);
            }
        }
        return ans;
    }
    
    public void dfs(ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> adj,int n,boolean vis[],int u)
    {
        vis[u]=true;
        ans.add(u);
        
        for(int i=0;i<adj.get(u).size();i++)
        {
            int v=adj.get(u).get(i);
            
            if(!vis[v])
            {
                dfs(ans,adj,n,vis,v);
            }
        }
    }
}
