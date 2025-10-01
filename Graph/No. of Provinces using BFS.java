// https://leetcode.com/problems/number-of-provinces/



class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    list.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int c = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { 
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;

                while (!q.isEmpty()) {
                    int curr = q.poll();

                    for (int nei : list.get(curr)) {
                        if (!visited[nei]) {
                            visited[nei] = true;
                            q.add(nei);
                        }
                    }
                }
                c++; 
            }
        }
        return c;
    }
}
