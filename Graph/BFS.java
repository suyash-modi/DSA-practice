
class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
         ArrayList<Integer> ans=new ArrayList<>();
        int V=adj.size();
        boolean vis[]=new boolean[V];
        
        Queue<Integer> q=new LinkedList<>();
        vis[0]=true;
        q.add(0);
        ans.add(0);
        
        while(!q.isEmpty())
        {
            int u=q.poll();
            
            for(int v : adj.get(u))
            {
                if(!vis[v])
                {
                    vis[v]=true;
                    ans.add(v);
                    q.offer(v);
                }
            }
        }
         
         return ans;
    
    }
}
