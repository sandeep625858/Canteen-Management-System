package com.canteen.canteenms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.canteen.canteenms.model.FoodList;

@Component
public interface AdminMenuDao extends JpaRepository<FoodList, Long> {

}
