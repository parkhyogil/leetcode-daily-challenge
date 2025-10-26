class Bank {
    private int n;
    private long[] balance;

    public Bank(long[] balance) {
        this.n = balance.length;
        this.balance = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        int i = account1 - 1, j = account2 - 1;

        if (i < 0 || j < 0 || i >= n || j >= n || balance[i] < money) {
            return false;
        }

        balance[j] += money;
        balance[i] -= money;

        return true;
    }
    
    public boolean deposit(int account, long money) {
        int i = account - 1;

        if (i < 0 || i >= n) {
            return false;
        }

        balance[i] += money;

        return true;
    }
    
    public boolean withdraw(int account, long money) {
        int i = account - 1;

        if (i < 0 || i >= n || balance[i] < money) {
            return false;
        }
        
        balance[i] -= money;

        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
