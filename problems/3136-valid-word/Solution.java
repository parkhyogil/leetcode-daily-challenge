class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }

        boolean containsVowel = false;
        boolean containsConsonant = false;

        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    containsVowel = true;
                } else {
                    containsConsonant = true;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }

        return containsVowel && containsConsonant;
    }
}
