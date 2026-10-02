package com.canteen.canteenms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.canteen.canteenms.model.FoodList;

public interface MenuDao extends JpaRepository<FoodList, Long>{
	@Query("Select f from FoodList f where f.foodStatus = 'Available' and f.month = :currMonth and f.year = :currYear")
	List<FoodList> findAllAvailiable(@Param("currMonth") String month,@Param("currYear") int year);


}
