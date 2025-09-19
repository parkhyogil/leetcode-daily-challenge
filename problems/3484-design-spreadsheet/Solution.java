class Spreadsheet {
    private int[][] grid;

    public Spreadsheet(int rows) {
        grid = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int r = Integer.parseInt(cell.substring(1)) - 1;
        int c = cell.charAt(0) - 'A';

        grid[r][c] = value;
    }
    
    public void resetCell(String cell) {
        int r = Integer.parseInt(cell.substring(1)) - 1;
        int c = cell.charAt(0) - 'A';
        
        grid[r][c] = 0;
    }
    
    public int getValue(String formula) {
        int i = formula.indexOf('+');

        String x = formula.substring(1, i);
        String y = formula.substring(i + 1);

        return getVal(x) + getVal(y);
    }

    private int getVal(String cell) {
        if (Character.isDigit(cell.charAt(0))) {
            return Integer.parseInt(cell);
        }

        int r = Integer.parseInt(cell.substring(1)) - 1;
        int c = cell.charAt(0) - 'A';

        return grid[r][c];
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
