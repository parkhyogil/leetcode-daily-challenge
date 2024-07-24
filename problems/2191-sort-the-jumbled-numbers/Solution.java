class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] mapped = map(nums, mapping);

        sort(nums, mapped);

        return nums;
    }

    public void sort(int[] nums, int[] mapped) {
        int n = nums.length;

        mergeSort(0, n - 1, nums, new int[n], mapped, new int[n]);
    }

    private void mergeSort(int l, int r, int[] nums, int[] tmp, int[] mapped, int[] tmpMapped) {
        if (l >= r) {
            return;
        }

        int m = (l + r) / 2;

        mergeSort(l, m, nums, tmp, mapped, tmpMapped);
        mergeSort(m + 1, r, nums, tmp, mapped, tmpMapped);

        merge(l, m, r, nums, tmp, mapped, tmpMapped);
    }

    private void merge(int l, int m, int r, int[] nums, int[] tmp, int[] mapped, int[] tmpMapped) {
        System.arraycopy(nums, l, tmp, l, m - l + 1);
        System.arraycopy(mapped, l, tmpMapped, l, m - l + 1);

        int idx = l;
        int i = l;
        int j = m + 1;

        while (i <= m && j <= r) {
            if (tmpMapped[i] <= mapped[j]) {
                nums[idx] = tmp[i];
                mapped[idx] = tmpMapped[i];
                i++;
            } else {
                nums[idx] = nums[j];
                mapped[idx] = mapped[j];
                j++;
            }

            idx++;
        }

        while (i <= m) {
            nums[idx] = tmp[i];
            mapped[idx++] = tmpMapped[i++];
        }
    }

    private int[] map(int[] nums, int[] mapping) {
        int n = nums.length;

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            if (num == 0) {
                res[i] = mapping[0];
            } else {
                int j = 1;

                while (num > 0) {
                    res[i] += j * mapping[num % 10];
                    num /= 10;

                    j *= 10;
                }
            }
        }

        return res;
    }
}
