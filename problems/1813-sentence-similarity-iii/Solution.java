class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        int m = sentence1.length();
        int n = sentence2.length();

        if (m < n) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        if (m == n) {
            return sentence1.equals(sentence2);
        }
        

        int left = -1;
        int right = n;

        int i = 0;

        while (i < n && sentence1.charAt(i) == sentence2.charAt(i)) {
            i++;
            if (sentence1.charAt(i) == ' ' && (i == n || sentence2.charAt(i) == ' ')) {
                left = i;
            }
        }

        if (left == n) {
            return true;
        }

        int j1 = m - 1;
        int j2 = n - 1;

        while (left < right && j2 >= 0 && sentence1.charAt(j1) == sentence2.charAt(j2)) {
            j1--;
            j2--;
            if (sentence1.charAt(j1) == ' ' && (j2 == -1 || sentence2.charAt(j2) == ' ')) {
                right = j2;
            }
        }

        return left == right;
    }
}
