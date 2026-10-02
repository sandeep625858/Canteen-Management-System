package com.canteen.canteenms.dao;
//Required Imports
import org.springframework.data.jpa.repository.JpaRepository;

import com.canteen.canteenms.model.FoodList;


// Extending the Interface of Jpa to use its inbuilt database Operation for Food List
public interface FoodListDao extends JpaRepository<FoodList, Long>{

}
