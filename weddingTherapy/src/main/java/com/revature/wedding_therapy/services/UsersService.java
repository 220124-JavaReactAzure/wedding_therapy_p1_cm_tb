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
		System.out.print("\nUsersService:createNewUsers\n");
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

}
