package com.canteen.canteenms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// Class or entity for Food Database
@Entity
public class FoodList {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long foodId;
	private String foodName;
	private String category;
	private String meal;
	private String foodStatus;
	private double foodPrice;
	private String month;
	private int year;
	public FoodList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodList(long foodId, String foodName, String category, String meal, String foodStatus, double foodPrice,
			String month, int year) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.category = category;
		this.meal = meal;
		this.foodStatus = foodStatus;
		this.foodPrice = foodPrice;
		this.month = month;
		this.year = year;
	}
	public long getFoodId() {
		return foodId;
	}
	public void setFoodId(long foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getFoodStatus() {
		return foodStatus;
	}
	public void setFoodStatus(String foodStatus) {
		this.foodStatus = foodStatus;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "FoodList [foodId=" + foodId + ", foodName=" + foodName + ", category=" + category + ", meal=" + meal
				+ ", foodStatus=" + foodStatus + ", foodPrice=" + foodPrice + ", month=" + month + ", year=" + year
				+ "]";
	}
	
	

	
}
