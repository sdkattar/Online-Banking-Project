package com.app.dao;

import java.util.List;

import com.app.pojos.Account;
import com.app.pojos.News;
import com.app.pojos.Role;
import com.app.pojos.Users;

public interface IUsersDao {

	Integer registerUser(Users users,Account a);
	
	Users loginUser(Users users);
	
	List<Users> getAllUsers();
	
	List<News> getAllNews();

	Users findByEmail(String email);
	
	public void setPass(String pass,String email);
	
	Account checkBalance(int uid);

	Object getSpecificUser(int parseInt);
	
	
	String updateCustomerDetails(int uid,Users u);
	
	Users getUserDetails(int uid);//get single account of single customer

	Users getUserAccountDetailsList(int uid);//get All accounts of single Customer
	
	public String updateprofile(Users user);
	
	public Users findById(Integer id);

	
	
	Integer signupUser(Users users);
	Integer createAccount(Account account);

	void addAcc(int id, Account acc);
	
	//public List<Users> findByRole();

	List<Users> findByRole(Role r);
	
	String transaction(int uid);
	
	String deleteUsers(Users u);
	
	public String editByAdmin(Users user);


	void acctransfer(int parseInt, int parseInt2, double parseDouble);
	
	List<Users> getManager();






	
}

