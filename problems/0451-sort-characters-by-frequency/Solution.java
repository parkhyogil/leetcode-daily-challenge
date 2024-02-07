class Solution {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();

        int[] freq = new int[126];

        for (char c : chars) {
            freq[c]++;
        }

        sort(chars, freq);

        return String.valueOf(chars);
    }

    private void sort(char[] chars, int[] freq) {
        quickSort(0, chars.length - 1, chars, freq);
    }

    private void quickSort(int l, int r, char[] chars, int[] freq) {
        if (l >= r) {
            return;
        }

        int pos = partition(l, r, chars, freq);

        quickSort(l, pos, chars, freq);
        quickSort(pos + 1, r, chars, freq);
    }

    private int partition(int l, int r, char[] chars, int[] freq) {
        int pivot = chars[(l + r) / 2];

        int i = l;
        int j = r;

        while (i <= j) {
            while (freq[pivot] < freq[chars[i]] || (freq[pivot] == freq[chars[i]] && pivot > chars[i])) {
                i++;
            }
            while (freq[pivot] > freq[chars[j]] || (freq[pivot] == freq[chars[j]] && pivot < chars[j])) {
                j--;
            }

            if (i < j) {
                swap(i, j, chars);
                i++;
                j--;
            } else {
                i++;
            }
        }
        return j;
    }

    private void swap(int i, int j, char[] chars) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
