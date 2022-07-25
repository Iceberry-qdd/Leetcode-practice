package C303;

import java.util.*;

class Food {
    String name;
    String cuisine;
    int rate;

    public Food() {
    }

    public Food(String name, String cuisine, int rate) {
        this.name = name;
        this.cuisine = cuisine;
        this.rate = rate;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCuisine() {
//        return cuisine;
//    }
//
//    public void setCuisine(String cuisine) {
//        this.cuisine = cuisine;
//    }
//
//    public int getRate() {
//        return rate;
//    }
//
//    public void setRate(int rate) {
//        this.rate = rate;
//    }

//    @Override
//    public int compareTo(Food food) {
//        if (this.rate > food.rate) return 1;
//        else if (this.rate < food.rate) return -1;
//        else if (this.name.compareTo(food.name) > 0) return 1;
//        else if (this.name.compareTo(food.name) < 0) return -1;
//        else return 0;
//    }
}

class FoodRatings {
    Map<String, PriorityQueue<Food>> cuisineMap;
    Map<String, Food> map;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int len = foods.length;
        map = new HashMap<>(len);
        cuisineMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            map.put(foods[i], food);
            PriorityQueue<Food> queue;
            if (!cuisineMap.containsKey(food.cuisine)) {
                queue = new PriorityQueue<>((f1, f2) -> (f2.rate - f1.rate == 0 ? f1.name.compareTo(f2.name) : f2.rate - f1.rate));
            } else {
                queue = cuisineMap.get(food.cuisine);
            }
            queue.add(food);
            cuisineMap.put(food.cuisine, queue);
        }
    }

    public void changeRating(String food, int newRating) {
        Food f = map.get(food);
        PriorityQueue<Food> queue = cuisineMap.get(f.cuisine);
        queue.remove(f);
        f.rate = newRating;
        queue.add(f);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> queue = cuisineMap.get(cuisine);
        Food food = queue.peek();
        return food != null ? food.name : "";
    }
}

public class C6126 {
    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(new String[]{"cpctxzh","bryvgjqmj","wedqhqrmyc","ee","lafzximxh","lojzxfel","flhs"}, new String[]{"wbhdgqphq","wbhdgqphq","mxxajogm","wbhdgqphq","wbhdgqphq","mxxajogm","mxxajogm"}, new int[]{15,5,7,16,16,10,13});
        foodRatings.changeRating("lojzxfel",1);
        System.out.println(foodRatings.highestRated("mxxajogm"));
        System.out.println(foodRatings.highestRated("wbhdgqphq"));
        System.out.println(foodRatings.highestRated("mxxajogm"));
    }
}
