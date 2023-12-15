class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> citiesHasOutgoing = new HashSet<>();

        for (List<String> path : paths) {
            citiesHasOutgoing.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (!citiesHasOutgoing.contains(path.get(1))) {
                return path.get(1);
            }
        }

        return "";
    }
}
