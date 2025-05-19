package com.piyas.Service;

import com.piyas.model.Category;
import com.piyas.model.Food;
import com.piyas.model.Restaurant;
import com.piyas.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

    void deleteFood(Long foodId) throws Exception;
    public List<Food> getRestaurantsFoods(Long restaurantId,
                                          boolean isVegetarian,
                                          boolean isNonveg,
                                          boolean isSeasonal,
                                          String foodCategory);

    public List<Food> searchFood(String keyword);
    public Food findFoodById(Long foodId) throws Exception;

    public Food updateAvailabilityStatus(Long foodId) throws Exception;


}
