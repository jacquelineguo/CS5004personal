package finalExam.p3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantRecommender {
    private Map<Restaurant, Integer> restaurantStatistics;
    private static final Integer INCREMENT_VALUE = 1;

    public RestaurantRecommender(List<Guest> guests) {
        this.restaurantStatistics = this.getAggregatedStatistics(guests);
    }

    private Map<Restaurant, Integer> getAggregatedStatistics(List<Guest> guests) {
        Map<Restaurant, Integer> result = new HashMap<>();
        for (Guest guest: guests) {
            for (Restaurant restaurant: guest.getVisitedRestaurant()) {
                if (result.containsKey(restaurant)) {
                    result.put(restaurant, result.get(restaurant) + INCREMENT_VALUE);
                }
                else {
                    result.put(restaurant, INCREMENT_VALUE);
                }
            }
        }
        return result;
    }

    public Restaurant recommendMostVisitedRestaurant() {
        Restaurant restaurant = null;
        Integer maxValue = 0;
        for (Map.Entry<Restaurant, Integer> entry: this.restaurantStatistics.entrySet()) {
            if (entry.getValue() > maxValue) {
                restaurant = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        return restaurant;
    }

    public Restaurant recommendHighlyRatedRestaurant(String cuisine) {
        return this.restaurantStatistics.keySet().stream().
                filter(restaurant -> restaurant.getCuisine().equalsIgnoreCase(cuisine)).
                max(Comparator.comparing(Restaurant::getRating)).get();
    }
}
