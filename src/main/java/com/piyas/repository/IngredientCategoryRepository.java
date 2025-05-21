package com.piyas.repository;

import com.piyas.model.IngredientCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory,Long> {

    List<IngredientCategory> findByRestaurantId(Long id);
}
