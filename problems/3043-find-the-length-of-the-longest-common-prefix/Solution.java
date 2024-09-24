class Solution {
    class TrieNode {
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[10];
        }
    }

    TrieNode root;

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        root = new TrieNode();

        for (int num : arr1) {
            insert(num);
        }

        int result = 0;

        for (int num : arr2) {
            result = Math.max(result, getPrefixLength(num));
        }

        return result;
    }

    int getPrefixLength(int num) {
        int length = 0;

        int divisor = (int) Math.pow(10, (int) Math.log10(num));

        TrieNode node = root;

        while (divisor > 0) {
            int quotient = num / divisor;
            int remainder = num % divisor;

            if (node.children[quotient] == null) {
                break;
            }

            node = node.children[quotient];

            divisor /= 10;
            num = remainder;

            length++;
        }

        return length;
    }

    void insert(int num) {
        int divisor = (int) Math.pow(10, (int) Math.log10(num));

        TrieNode node = root;

        while (divisor > 0) {
            int quotient = num / divisor;
            int remainder = num % divisor;

            if (node.children[quotient] == null) {
                node.children[quotient] = new TrieNode();
            }

            node = node.children[quotient];

            divisor /= 10;
            num = remainder;
        }
    }
}
