/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    class Step {
        private Node node;
        private int childNodeIdx;

        public Step(Node node) {
            this.node = node;
            childNodeIdx = 0;
        }

        public boolean areAllChildNodesProcessed() {
            return childNodeIdx == node.children.size();
        }

        public int getValue() {
            return node.val;
        }

        public Step getNextStep() {
            return new Step(node.children.get(childNodeIdx++));
        }
    }

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        // traverseRecursively(root, result);
        traverseIteratively(root, result);

        return result;
    }

    private void traverseIteratively(Node node, List<Integer> result) {
        Stack<Step> stack = new Stack<>();

        stack.push(new Step(node));

        while (!stack.isEmpty()) {
            Step step = stack.peek();

            if (step.areAllChildNodesProcessed()) {
                result.add(step.getValue());
                stack.pop();
            } else {
                stack.push(step.getNextStep());
            }
        }
    }

    private void traverseRecursively(Node node, List<Integer> result) {
        for (Node child : node.children) {
            traverseRecursively(child, result);
        }

        result.add(node.val);
    }
}
