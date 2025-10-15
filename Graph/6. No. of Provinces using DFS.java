// https://leetcode.com/problems/number-of-provinces/

class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis = new boolean[isConnected.length];
        int c = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!vis[i]) {
                c++;
                dfs(isConnected, i, vis);
            }
        }
        return c;
    }

    public static void dfs(int[][] isConnected, int curr, boolean[] vis) {
        vis[curr] = true;
        for (int j = 0; j < isConnected[curr].length; j++) {
            if (isConnected[curr][j] == 1 && !vis[j]) {
                dfs(isConnected, j, vis);
            }
        }
    }
}
