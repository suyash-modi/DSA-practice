// https://leetcode.com/problems/course-schedule/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 1) return true;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = numCourses;

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int vis[] = new int[V];
        int pathVis[] = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0 && dfsCheck(i, adj, vis, pathVis)) {
                return false; // Change here to return false when a cycle is detected
            }
        }
        return true; // Change here to return true when no cycle is detected
    }

    public boolean dfsCheck(int i, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[]) {
        vis[i] = 1;
        pathVis[i] = 1;

        for (int it : adj.get(i)) {
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis)) {
                    return true;
                }
            } else if (pathVis[it] == 1) {
                // When a cycle is detected, mark all nodes in the current path as not in the path
                for (int node : adj.get(i)) {
                    pathVis[node] = 0;
                }
                return true;
            }
        }

        pathVis[i] = 0;
        return false;
    }
}
