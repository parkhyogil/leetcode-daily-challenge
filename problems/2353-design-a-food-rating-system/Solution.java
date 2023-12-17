class FoodRatings {
    private Map<String, TreeSet<String>> groupByCuisine;
    private Map<String, Integer> ratingOf;
    private Map<String, String> cuisineOf;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        groupByCuisine = new HashMap<>();
        ratingOf = new HashMap<>();
        cuisineOf = new HashMap<>();

        int n = foods.length;

        for (int i = 0; i < n; i++) {
            ratingOf.put(foods[i], ratings[i]);
            cuisineOf.put(foods[i], cuisines[i]);

            groupByCuisine.computeIfAbsent(cuisines[i], key -> new TreeSet<>((a, b) -> {
                int compare = ratingOf.get(b) - ratingOf.get(a);
                if (compare == 0) {
                    return a.compareTo(b);
                }
                return compare;
            })).add(foods[i]);
        }    
    }
    
    public void changeRating(String food, int newRating) {
        groupByCuisine.get(cuisineOf.get(food)).remove(food);
        ratingOf.put(food, newRating);
        groupByCuisine.get(cuisineOf.get(food)).add(food);
    }
    
    public String highestRated(String cuisine) {
        return groupByCuisine.get(cuisine).first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
