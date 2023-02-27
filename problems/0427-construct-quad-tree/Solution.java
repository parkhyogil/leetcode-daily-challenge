class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, grid.length, 0, grid.length);
    }

    private Node build(int[][] grid, int r1, int r2, int c1, int c2) {
        if (isSame(grid, r1, r2, c1, c2)) {
            return new Node(grid[r1][c1] == 1, true);
        }
        int rm = (r1 + r2) / 2;
        int cm = (c1 + c2) / 2;
        return new Node(false, false, 
            build(grid, r1, rm, c1, cm),
            build(grid, r1, rm, cm, c2),
            build(grid, rm, r2, c1, cm),
            build(grid, rm, r2, cm, c2)
        );
    }

    private boolean isSame(int[][] grid, int r1, int r2, int c1, int c2) {
        int val = grid[r1][c1];
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                if (val != grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/
