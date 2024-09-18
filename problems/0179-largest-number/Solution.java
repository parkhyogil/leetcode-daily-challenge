class Solution {
    private final Comparator<String> customStringComparator = (s1, s2) -> {
        int len1 = s1.length();
        int len2 = s2.length();

        int i = 0;

        while (i < len1 + len2) {
            char c1 = i < len1 ? s1.charAt(i) : s2.charAt(i % len1);
            char c2 = i < len2 ? s2.charAt(i) : s1.charAt(i % len2);

            if (c1 == c2) {
                i++;
            } else {
                return Character.compare(c2, c1);
            }
        }

        return 0;
    };
    
    public String largestNumber(int[] nums) {
        List<String> sortedStringNums = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted(customStringComparator)
                .collect(Collectors.toList());

        if (sortedStringNums.get(0).equals("0")) {
            return "0";
        }

        return String.join("", sortedStringNums);
    }
}
