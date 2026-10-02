package com.canteen.canteenms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.canteen.canteenms.dao.AdminMenuDao;
import com.canteen.canteenms.model.FoodList;



@Component
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminMenuDao fdao;

	// Fetch existing menu from the database
	@Override
	public List<FoodList> getAllFoodItems() {
		return fdao.findAll();
	}

	// Add Food Item to the database
	@Override
	public String addFoodItem(FoodList f) {
		// TODO Auto-generated method stub
		try {			
			fdao.save(f);
		} catch(Exception e) {
			//return "Failed";
			e.printStackTrace();
		}
		return "Success";
	}

	@Override
	public FoodList getFoodById(long fId) {
		FoodList food = fdao.getById(fId);
		return food;
	}

	@Override
	public void updateFoodItem(FoodList f) {
		fdao.saveAndFlush(f);
	}

	@Transactional
	@Override
	public void deleteFoodById(long fId) {
		fdao.deleteById(fId);
	}

	
}
