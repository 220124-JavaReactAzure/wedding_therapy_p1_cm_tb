package com.revature.wedding_therapy.services;

import java.util.List;

import com.revature.wedding_therapy.dao.UsersDAO;
import com.revature.wedding_therapy.models.Users;

public class UsersService {
	

	private UsersDAO usersDAO;
	//private WeddingDAO weddingDAO;
	
	public UsersService(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	
	
	public boolean createNewUsers(Users account) {
		return usersDAO.createNewUser(account);
	}
	
	public List<Users> getAllUsers(){
		System.out.print("\n\n\nUsersService:getAllUsers\n\n\n");
		return usersDAO.getAllUsers();
	}

}
