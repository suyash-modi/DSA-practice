// https://leetcode.com/problems/course-schedule/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
         int indeg[]=new int[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

         int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indeg[prerequisites[i][0]]++;
        }

       int vis[]=new int[numCourses];

       return bfs(vis,adj,indeg,numCourses);

    }

    public boolean bfs(int vis[], ArrayList<ArrayList<Integer>> adj,int indeg[],int n)
    {
        Queue<Integer> q=new LinkedList<>();
        int c=0;

        for(int i=0;i<n;i++)
        {
            if(indeg[i]==0)
            {
                c++;
                q.offer(i);
            }
        }

        while(!q.isEmpty())
        {
            int u=q.poll();
            vis[u]=1;

            for(int v : adj.get(u))
            {
                indeg[v]--;

                if(indeg[v]==0)
                {
                    c++;
                    q.offer(v);
                }


            }

        }

        return c==n;
    }

}
