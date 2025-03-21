class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;

        Map<String, Integer> recipeIdMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            recipeIdMap.put(recipes[i], i);
        }
        Set<String> supply = Arrays.stream(supplies).collect(Collectors.toSet());
        boolean[] visit = new boolean[n];

        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (canCreate(i, recipes, ingredients, recipeIdMap, supply, visit)) {
                result.add(recipes[i]);
            }
        }

        return result;
    }

    private boolean canCreate(int id, String[] recipes, List<List<String>> ingredients, Map<String, Integer> recipeIdMap, Set<String> supply, boolean[] visit) {
        if (visit[id]) {
            return supply.contains(recipes[id]);
        }

        visit[id] = true;

        for (String ingredient : ingredients.get(id)) {
            if (!supply.contains(ingredient) && (!recipeIdMap.containsKey(ingredient) || !canCreate(recipeIdMap.get(ingredient), recipes, ingredients, recipeIdMap, supply, visit))) {
                return false;
            }
        }

        supply.add(recipes[id]);
        return true;
    }
}
