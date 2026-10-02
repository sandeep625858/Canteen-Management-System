package com.canteen.canteenms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.canteen.canteenms.model.FoodList;


@Component
public interface AdminFoodListDao extends JpaRepository<FoodList,Long>{

	
}
