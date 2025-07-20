class Solution {
    class Node {
        int count;
        String name, pathString;
        Map<String, Node> children;
        List<String> path;

        Node(String name) {
            this.name = name;
            children = new HashMap<>();
        }
    }

    Node root;
    Map<String, String> nodeSignMap;
    Map<String, Integer> signCountMap;

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        root = new Node("/");
        nodeSignMap = new HashMap<>();
        signCountMap = new HashMap<>();

        paths.sort((a, b) -> a.size() - b.size());

        for (List<String> path : paths) {
            insert(path);
        }

        buildNodeSign(root);

        List<List<String>> result = new ArrayList<>();

        for (Node node : root.children.values()) {
            dfs(node, result);
        }

        return result;
    }

    void dfs(Node node, List<List<String>> result) {
        String sign = nodeSignMap.get(node.pathString);
        if (!sign.isEmpty() && signCountMap.get(sign) > 1) {
            return;
        }

        result.add(node.path);

        for (Node child : node.children.values()) {
            dfs(child, result);
        }
    }

    String buildNodeSign(Node node) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Node> children = new ArrayList<>(node.children.values());
        children.sort((a, b) -> a.name.compareTo(b.name));

        for (Node child : children) {
            sb.append(buildNodeSign(child));
        }

        nodeSignMap.put(node.pathString, sb.toString());
        signCountMap.merge(nodeSignMap.get(node.pathString), 1, Integer::sum);

        sb.append(node.name).append(node.count);

        return sb.toString();
    }

    void insert(List<String> path) {
        Node node = root;
        StringBuilder sb = new StringBuilder();
        for (String name : path) {
            sb.append('/').append(name);
            node.count++;
            node = node.children.computeIfAbsent(name, k -> new Node(k));
        }

        node.pathString = sb.toString();
        node.path = path;
    }
}
