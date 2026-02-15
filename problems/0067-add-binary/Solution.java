class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = (i < 0 ? 0 : a.charAt(i) - '0') + (j < 0 ? 0 : b.charAt(j) - '0') + carry;

            sb.append(sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }

        return sb.reverse().toString();
    }
}
