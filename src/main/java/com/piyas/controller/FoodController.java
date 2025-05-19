package com.piyas.controller;

import com.piyas.Service.FoodService;
import com.piyas.Service.RestaurantService;
import com.piyas.Service.UserService;
import com.piyas.model.Food;
import com.piyas.model.Restaurant;
import com.piyas.model.User;
import com.piyas.request.CreateFoodRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String name,
                                           @RequestHeader("Authorization") String jwt) throws Exception{

        User user=userService.findUserByJwtToken(jwt);

        List<Food> foods=foodService.searchFood(name);

        return new ResponseEntity<>(foods, HttpStatus.CREATED);
    }

    @GetMapping("/restaurant/{restaurantID}")
    public ResponseEntity<List<Food>> getRestaurantFood(
            @RequestParam boolean vagetarian,
            @RequestParam boolean nonveg,
            @RequestParam boolean seasonal,
            @RequestParam(required = false) String food_category,
            @PathVariable Long restaurantID,
            @RequestHeader("Authorization") String jwt) throws Exception{

        User user=userService.findUserByJwtToken(jwt);

        List<Food> foods=foodService.getRestaurantsFoods(restaurantID,vagetarian,nonveg,seasonal,food_category);

        return new ResponseEntity<>(foods, HttpStatus.OK);
    }


}
