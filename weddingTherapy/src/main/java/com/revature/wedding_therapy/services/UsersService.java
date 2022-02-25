package com.revature.wedding_therapy.services;

import java.util.List;

import com.revature.wedding_therapy.dao.UsersDAO;
import com.revature.wedding_therapy.exceptions.InvalidRequestException;
import com.revature.wedding_therapy.models.Users;

public class UsersService {
	

	private UsersDAO usersDAO;
	//private WeddingDAO weddingDAO;
	
	public UsersService(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	
	
	public boolean createNewUsers(Users account) throws InvalidRequestException {
		System.out.print("\nUsersService:createNewUsers\n");
		if(!isUsersValid(account)) {
			throw new InvalidRequestException("Invalid user data provider");
		}
		return usersDAO.createNewUser(account);
	}

	public List<Users> getAllUsers(){
		System.out.print("\nUsersService:getAllUsers\n");
		return usersDAO.getAllUsers();
	}
	
	public Users getUserId(int id) {
		System.out.print("\nUsersService:getUserId\n");
		return usersDAO.getUserById(id);
	}
	
	public boolean updateUsers(Users user) {
		System.out.print("\nUsersService:updateUsers\n");
		return usersDAO.updateUsers(user);
	}
	
	public boolean deleteUsers(int id) {
		System.out.print("\nUsersService:deleteUsers\n");
		return usersDAO.deleteUsers(id);
	}

	private boolean isUsersValid(Users account) {
		if(account == null) return false;
		if(account.getFirstname() == null || account.getFirstname().trim().equals("")) return false;
		if(account.getLastname() == null || account.getLastname().trim().equals("")) return false;
		if(account.getEmail() == null || account.getEmail().trim().equals("")) return false;
		if(account.getMeal() == null) return false;
		if(account.getPlus_one_meal() == null) return false;
		if(account.getWedding() == null) return false;
		return true;
	}
	
}
