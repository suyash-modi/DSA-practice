// https://www.geeksforgeeks.org/problems/topological-sort/1

class Solution
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> st=new Stack<>();
        boolean vis[]=new boolean[V];
        
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                dfs(adj,V,vis,st,i);
            }
        }
        int i=0;
        int ans[]=new int[V];
        
        while(!st.isEmpty())
        {
            ans[i++]=st.pop();
        }
        
        return ans;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj,int V,boolean vis[],Stack<Integer> st,int u)
    {
        vis[u]=true;
        
        for(int v : adj.get(u))
        {
            if(!vis[v])
            {
                 dfs(adj,V,vis,st,v);
            }
        }
        
        st.push(u);
    }
}
