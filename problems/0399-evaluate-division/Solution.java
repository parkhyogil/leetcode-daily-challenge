class Solution {
    Map<String, String> roots = new HashMap<>();
    Map<String, Double> dist = new HashMap<>();
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String r1 = findRoot(equation.get(0));
            String r2 = findRoot(equation.get(1));
            
            roots.put(r1, r2);
            dist.put(r1, dist.get(equation.get(1)) * values[i] / dist.get(equation.get(0)));
        }
        
        int n = queries.size();
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);
            if (!roots.containsKey(a) || !roots.containsKey(b)) {
                res[i] = -1;
                continue;
            }
            
            String r1 = findRoot(a);
            String r2 = findRoot(b);
            if (!r1.equals(r2)) {
                res[i] = -1;
                continue;
            }
            
            res[i] = dist.get(a) / dist.get(b);
        }
        return res;
    }
    
    private String findRoot(String child) {
        if (!roots.containsKey(child)) {
            roots.put(child, child);
            dist.put(child, 1.0);
            return child;
        }
        if (!roots.get(child).equals(child)) {
            String p = roots.get(child);
            roots.put(child, findRoot(p));
            dist.put(child, dist.get(child) * dist.get(p));
        }
        return roots.get(child);
    }
}
