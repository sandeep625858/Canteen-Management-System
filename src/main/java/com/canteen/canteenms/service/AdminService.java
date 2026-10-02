package com.canteen.canteenms.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.canteen.canteenms.model.FoodList;

@Service
public interface AdminService {
	
	abstract List<FoodList> getAllFoodItems();
	
	abstract FoodList getFoodById(long fId);

	abstract String addFoodItem(FoodList f);
	
	abstract void updateFoodItem(FoodList f);
	
	abstract void deleteFoodById(long fId);
}
