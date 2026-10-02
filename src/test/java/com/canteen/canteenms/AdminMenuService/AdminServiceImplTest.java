package com.canteen.canteenms.AdminMenuService;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.canteen.canteenms.dao.AdminMenuDao;
import com.canteen.canteenms.model.FoodList;
import com.canteen.canteenms.service.AdminServiceImpl;

@SpringBootTest
public class AdminServiceImplTest {

	// Autowiring the object of the service class to be tested
	@Autowired
	private AdminServiceImpl adminService;
	
	// Mocking the AdminMenuDao instead of calling the actual code
	@MockBean
	private AdminMenuDao adminMenuDao;
	
	@Test
	public void testAddFoodItem() {
		FoodList food = new FoodList();
		food.setFoodName("Aloo Paratha");
		food.setCategory("Veg");
		food.setMeal("Brekfast");
		food.setFoodStatus("Available");
		food.setFoodPrice(30);
		food.setMonth("January");
		food.setYear(2023);
			
		assertEquals("Success", adminService.addFoodItem(food));
	}
	
	@Test
	public void testGetFoodById() {
		FoodList food = new FoodList();
		food.setFoodId(10);
		food.setFoodName("Aloo Paratha");
		food.setCategory("Veg");
		food.setMeal("Brekfast");
		food.setFoodStatus("Available");
		food.setFoodPrice(30);
		food.setMonth("January");
		food.setYear(2023);
		
		Mockito.when(adminMenuDao.getById(food.getFoodId())).thenReturn(food);
		
		assertThat(adminService.getFoodById(food.getFoodId())).isEqualTo(food);
	}
	
	@Test
	public void testGetAllFoodItems() {
		
		List<FoodList> foodList = new ArrayList<>();
		
		FoodList food1 = new FoodList(2, "Biryani", "Nonveg", "Lunch", "Available", 150,
		"January", 2023);
		FoodList food2 = new FoodList(3, "Caesar Salad", "Veg", "Breakfast", "Available", 60,
				"January", 2023);
		FoodList food3 = new FoodList(4, "Chicken Sandwich", "Nonveg", "Breakfast", "Available", 80,
				"January", 2023);
		FoodList food4 = new FoodList(5, "Paneer Pizza", "Veg", "Lunch", "Available", 200,
				"January", 2023);
		FoodList food5 = new FoodList(10, "Aloo Paratha", "Veg", "Breakfast", "Available", 30,
				"January", 2023);
		
		foodList.add(food1);
		foodList.add(food2);
		foodList.add(food3);
		foodList.add(food4);
		foodList.add(food5);
		
		Mockito.when(adminMenuDao.findAll()).thenReturn(foodList);
		
		assertThat(adminService.getAllFoodItems()).isEqualTo(foodList);
	}
	

}

