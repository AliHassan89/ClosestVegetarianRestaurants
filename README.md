# ClosestVegetarianRestaurants

Given an array representing the locations of N vegetarian restaurants in the city, implement an
algorithm to find the nearest X vegetarian restaurants to the customer's location.

The customer is always located on 0,0 location.
You can think of the distance from customer to the restaurant location as square root of x^2 multiply by y^2.
Math.sqrt(square(x) + square(y))

Find first M number of restaurant which are closest to the customer. M is the numRestaurants.

```
input:
totalRestaurants = 5
allLocations = [(-1,0), (1,1), (5,4), (2,1), (4,2)]
numRestaurants = 2

output:
[(-1,0), (1,1), (2,1)]
```
# Solution:

- Create a pair class and map all locations into that pair class.
- Create a map where key is Pair and value is distance from customer location.
- Fill the map.
- Sort the map by values in ascending order.
- Loop over the map and get first numRestaurants and add them to a new list. Return the new list.
