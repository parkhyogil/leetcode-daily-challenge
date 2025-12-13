class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;

        Set<String> categories = Set.of("electronics", "grocery", "pharmacy", "restaurant");

        return IntStream.range(0, n).boxed()
                .filter(i -> isActive[i] && isValidCode(code[i]) && categories.contains(businessLine[i]))
                .sorted((a, b) -> {
                    int d = businessLine[a].compareTo(businessLine[b]);
                    return d == 0 ? code[a].compareTo(code[b]) : d;
                })
                .map(i -> code[i])
                .collect(Collectors.toList());
    }

    boolean isValidCode(String code) {
        if (code.isEmpty()) {
            return false;
        }

        for (char c : code.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }
}
