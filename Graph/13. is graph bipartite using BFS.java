
// https://leetcode.com/problems/is-graph-bipartite/

class Solution {
    public boolean isBipartite(int[][] graph) {
        int col[]=new int[graph.length];
        for(int i=0;i<col.length;i++)
        {
            col[i]=-1;
        }
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<graph.length;i++)
        {
            if(col[i]==-1)
            {
                q.add(i);
                col[i]=0;
                
                while(!q.isEmpty())
                {
                    int curr=q.remove();
                    for(int j=0;j<graph[curr].length;j++)
                    {
                        if(col[graph[curr][j]]==-1)
                        {
                            int nextcol=col[curr]==0?1:0;
                            col[graph[curr][j]]=nextcol;
                            q.add(graph[curr][j]);
                        }
                        else if(col[graph[curr][j]]==col[curr])
                        {
                            return false;
                        }
                    }
                }
                
            }
            
        }
        return true;
    }
}
