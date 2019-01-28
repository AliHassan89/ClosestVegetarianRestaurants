/*
Given an array representing the locations of N vegetarian restaurants in the city, implement an
algorithm to find the nearest X vegetarian restaurants to the customer's location.

The customer is always located on 0,0 location.
You can think of the distance from customer to the restaurant location as square root of x^2 multiply by y^2.
Math.sqrt(square(x) + square(y))

Find first M number of restaurant which are closest to the customer. M is the numRestaurants.


input:
totalRestaurants = 5
allLocations = [(-1,0), (1,1), (5,4), (2,1), (4,2)]
numRestaurants = 2

output:
[(-1,0), (1,1), (2,1)]

Solution:

- Create a pair class and map all locations into that pair class.
- Create a map where key is Pair and value is distance from customer location.
- Fill the map.
- Sort the map by values in ascending order.
- Loop over the map and get first numRestaurants and add them to a new list. Return the new list.

*/

import java.util.*;

public class ClosestVegitarianRestaurant {
    List<List<Integer>> nearestVegetarianRestaurant(int totalRestaurants, List<List<Integer>> allLocations,
            int numRestaurants)
    {
        List<Pair> pairLocations = new ArrayList<>();
        for (List<Integer> location : allLocations) {
            Pair p = new Pair(location.get(0), location.get(1));
            pairLocations.add(p);
        }

        Map<Pair, Double> map = new HashMap<>();
        for (Pair pair : pairLocations) {
            double distance = Math.sqrt((pair.getX() * pair.getX()) + (pair.getY() * pair.getY()));
            map.put(pair, distance);
        }

        SortedSet<Map.Entry<Pair, Double>> sorted = entriesSortedByValues(map);

        Iterator<Map.Entry<Pair, Double>> it = sorted.iterator();
        List<List<Integer>> result = new ArrayList<>();
        while(it.hasNext()) {
            Map.Entry<Pair, Double> entry = it.next();
            Pair p = entry.getKey();
            List<Integer> list = new ArrayList<>();
            list.add(p.getX());
            list.add(p.getY());
            result.add(list);
            if (result.size() == numRestaurants) {
                break;
            }
        }

        return result;
    }

    private static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<>(
                (e1, e2) -> {
                    int res = e1.getValue().compareTo(e2.getValue());
                    return res != 0 ? res : 1;
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    private class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
