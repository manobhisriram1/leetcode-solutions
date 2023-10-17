class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
       int[] inDegrees = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                inDegrees[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                inDegrees[rightChild[i]]++;
            }
        }

        // Find the root node (in-degree = 0)
        int rootNode = -1;
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                if (rootNode != -1) {
                    // Multiple nodes with in-degree 0, not a valid binary tree
                    return false;
                }
                rootNode = i;
            } else if (inDegrees[i] > 1) {
                // Node with in-degree > 1, not a valid binary tree
                return false;
            }
        }

        // No root node found, not a valid binary tree
        if (rootNode == -1) {
            return false;
        }

        // Perform DFS to check for cycles and reachability
        boolean[] visited = new boolean[n];
        return dfs(rootNode, leftChild, rightChild, visited) == n;
    }

    private int dfs(int node, int[] leftChild, int[] rightChild, boolean[] visited) {
        if (node == -1 || visited[node]) {
            return 0;
        }
        visited[node] = true;
        int count = 1;
        count += dfs(leftChild[node], leftChild, rightChild, visited);
        count += dfs(rightChild[node], leftChild, rightChild, visited);
        return count;  
    }
}