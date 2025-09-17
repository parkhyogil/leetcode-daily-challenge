class FoodRatings {
    Map<String, Integer> foodRating;
    Map<String, String> foodCuisine;
    Map<String, PriorityQueue<Pair<String, Integer>>> queues;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRating = new HashMap<>();
        foodCuisine = new HashMap<>();
        queues = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodRating.put(foods[i], ratings[i]);
            foodCuisine.put(foods[i], cuisines[i]);

            queues.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>((a, b) -> a.getValue() - b.getValue() == 0 ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue())).offer(new Pair<>(foods[i], ratings[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        if (foodRating.get(food) == newRating) {
            return;
        }

        foodRating.put(food, newRating);
        queues.get(foodCuisine.get(food)).offer(new Pair<>(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Pair<String, Integer>> queue = queues.get(cuisine);
    
        while (!queue.isEmpty()) {
            Pair<String, Integer> top = queue.peek();

            if (top.getValue().equals(foodRating.get(top.getKey()))) {
                return top.getKey();
            }

            queue.poll();
        }

        return "";
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
