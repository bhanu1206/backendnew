package com.infinite.repository;

import java.util.List;

import com.infinite.model.Restaurant;

public interface IRestaurantDao {

	public List<Restaurant> getRestaurant();
	
	public Restaurant addrestaurant(Restaurant restaurant);
	
	public Restaurant validateRestaurant(String username, String password);
}
