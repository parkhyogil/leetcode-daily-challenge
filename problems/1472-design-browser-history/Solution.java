class BrowserHistory {
    private List<String> urls;
    private int curr, last;

    public BrowserHistory(String homepage) {
        urls = new ArrayList<>();
        urls.add(homepage);    
        curr = 0;
        last = 0;
    }
    
    public void visit(String url) {
        if (curr == urls.size() - 1) {
            urls.add(url);
        } else {
            urls.set(curr + 1, url);
        }
        curr++;
        last = curr;
    }
    
    public String back(int steps) {
        curr = Math.max(0, curr - steps);
        return urls.get(curr);
    }
    
    public String forward(int steps) {
        curr = Math.min(last, curr + steps);
        return urls.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
