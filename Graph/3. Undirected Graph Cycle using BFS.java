// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1



class Solution {
    // Function to detect cycle in an undirected graph.
    
    public class Node
    {
        int node;
        int par;
        
        public Node(int node,int par)
        {
            this.node=node;
            this.par=par;
        }
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
         
        boolean vis[]=new boolean[V];
        
        for(int i=0;i<V;i++)
        {
            if(!vis[i] &&  bfs(adj,vis,i,-1))
            {
                return true;
            }
        }
        
        return false;
    }
    
     private  boolean bfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],int u,int p)
    {
        
        Queue<Node> q=new LinkedList<>();
        
        vis[u]=true;
        q.offer(new Node(u,-1));
        
        while(!q.isEmpty())
        {
            
            Node self=q.poll();
            
            int curr=self.node;
            
            int parent=self.par;
            
            
             for(int v: adj.get(curr))
        {
            if(v==parent) continue;
            
            if(vis[v]) return true;
            
            vis[v]=true;
           
           q.offer(new Node(v,curr));
           
        }
    }
    
    return false;
            
        }
        
}





