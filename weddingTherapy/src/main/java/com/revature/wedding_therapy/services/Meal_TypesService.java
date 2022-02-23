package com.revature.wedding_therapy.services;

import java.util.List;

import com.revature.wedding_therapy.dao.Meal_TypesDAO;
import com.revature.wedding_therapy.exceptions.MealTypesNotNamedException;
import com.revature.wedding_therapy.models.Meal_Types;

public class Meal_TypesService {

	private Meal_TypesDAO meal_TypesDAO;
	
	public Meal_TypesService(Meal_TypesDAO meal_TypesDAO) {
		this.meal_TypesDAO = meal_TypesDAO;
	}
	
	
	public boolean createNewMeal_Type(Meal_Types meal_Types) throws MealTypesNotNamedException {
		if(meal_Types.getMeal_type() == null || meal_Types.getMeal_type().equals("")) {
			throw new MealTypesNotNamedException("You Must Give This Meal A Type");
		}
		return meal_TypesDAO.createNewMeal_Types(meal_Types);
	}
	
	
	public List<Meal_Types> getAllMeal_Types() {
		return meal_TypesDAO.getAllMeal_Types();
	}
	
	
	public Meal_Types getMeal_TypeId(int id) {
		return meal_TypesDAO.getMeal_TypesId(id);
	}
	
	
	public boolean updateMeal_Types(Meal_Types meal_Types) {
		return meal_TypesDAO.updateMeal_Types(meal_Types);
	}
	
	
	public boolean deleteMeal_Types(int id) {
		return meal_TypesDAO.deleteMeal_Types(id);
	}
	
}
