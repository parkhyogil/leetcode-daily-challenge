class Solution {
    private Map<Integer, String> numberToWordMap;

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        initializeNumberToWordMap();

        return convertNumberToWordsRecursively(0, num);
    }

    private String convertHundredsToWords(int num) {
        StringBuilder sb = new StringBuilder();

        if (num / 100 > 0) {
            sb.append(numberToWordMap.get(num / 100)).append(" Hundred ");
            num %= 100;
        }

        if (num / 10 >= 2) {
            sb.append(numberToWordMap.get(num / 10 * 10)).append(' ').append(numberToWordMap.get(num % 10)).append(' ');
        } else {
            sb.append(numberToWordMap.get(num)).append(' ');
        }

        return sb.toString().trim();
    }

    private String convertNumberToWordsRecursively(int depth, int num) {
        StringBuilder sb = new StringBuilder();
        
        if (num / 1000 > 0) {
            sb.append(convertNumberToWordsRecursively(depth + 1, num / 1000)).append(' ');
        }

        if (num % 1000 > 0) {
            sb.append(convertHundredsToWords(num % 1000));

            if (depth == 3) {
                sb.append(" Billion");
            } else if (depth == 2) {
                sb.append(" Million");
            } else if (depth == 1) {
                sb.append(" Thousand");
            }
        }

        return sb.toString().trim();
    }

    private void initializeNumberToWordMap() {
        numberToWordMap = new HashMap<>();

        numberToWordMap.put(0, "");
        numberToWordMap.put(1, "One");
        numberToWordMap.put(2, "Two");
        numberToWordMap.put(3, "Three");
        numberToWordMap.put(4, "Four");
        numberToWordMap.put(5, "Five");
        numberToWordMap.put(6, "Six");
        numberToWordMap.put(7, "Seven");
        numberToWordMap.put(8, "Eight");
        numberToWordMap.put(9, "Nine");

        numberToWordMap.put(10, "Ten");
        numberToWordMap.put(11, "Eleven");
        numberToWordMap.put(12, "Twelve");
        numberToWordMap.put(13, "Thirteen");
        numberToWordMap.put(14, "Fourteen");
        numberToWordMap.put(15, "Fifteen");
        numberToWordMap.put(16, "Sixteen");
        numberToWordMap.put(17, "Seventeen");
        numberToWordMap.put(18, "Eighteen");
        numberToWordMap.put(19, "Nineteen");

        numberToWordMap.put(20, "Twenty");
        numberToWordMap.put(30, "Thirty");
        numberToWordMap.put(40, "Forty");
        numberToWordMap.put(50, "Fifty");
        numberToWordMap.put(60, "Sixty");
        numberToWordMap.put(70, "Seventy");
        numberToWordMap.put(80, "Eighty");
        numberToWordMap.put(90, "Ninety");
    }
}
