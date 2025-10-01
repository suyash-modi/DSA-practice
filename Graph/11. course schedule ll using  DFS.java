// https://leetcode.com/problems/course-schedule-ii/

import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create adjacency list representation of the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        // Perform DFS to find topological ordering
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] recursionStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && !dfs(i, graph, visited, recursionStack, stack)) {
                return new int[0]; // If there is a cycle, return an empty array
            }
        }

        // Populate the result array from the stack
        int[] result = new int[numCourses];
        int index = numCourses - 1;
        while (!stack.isEmpty()) {
            result[index--] = stack.pop();
        }

        return result;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] recursionStack, Stack<Integer> stack) {
        visited[node] = true;
        recursionStack[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (!dfs(neighbor, graph, visited, recursionStack, stack)) {
                    return false; // If there is a cycle, return false
                }
            } else if (recursionStack[neighbor]) {
                return false; // If there is a cycle, return false
            }
        }

        recursionStack[node] = false;
        stack.push(node);

        return true;
    }
}