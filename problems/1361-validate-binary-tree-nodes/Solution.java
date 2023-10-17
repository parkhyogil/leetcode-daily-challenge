class Solution {
    private int[] root;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        root = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        int numOfTree = n;

        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            
            if (left != -1) {
                if (root[left] != left || findRoot(i) == findRoot(left)) {
                    return false;
                }

                root[left] = i;
                numOfTree--;
            }

            int right = rightChild[i];

            if (right != -1) {
                if (root[right] != right || findRoot(i) == findRoot(right)) {
                    return false;
                }

                root[right] = i;
                numOfTree--;
            }
        }

        return numOfTree == 1;
    }

    private int findRoot(int child) {
        if (child == root[child]) {
            return child;
        }
        return root[child] = findRoot(root[child]);
    }
}
