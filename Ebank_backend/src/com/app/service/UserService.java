package com.app.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUsersDao;
import com.app.pojos.Account;
import com.app.pojos.AccountTransfer;
import com.app.pojos.News;
import com.app.pojos.Role;
//import com.app.pojos.User;
import com.app.pojos.Users;

@Service
//@Transactional
public class UserService 
{

	UserService()
	{
		System.out.println("in user service");
	}
	
	@Autowired
	private IUsersDao usersdao;
	
	public Integer registerUser(Users user,Account account)
	{
		return usersdao.registerUser(user, account);
	}


	public Users loginUser(Users user)
	{
		return usersdao.loginUser(user);
	
	}
	

	public	List<Users> getAllUsers()
	{
		return usersdao.getAllUsers();
	
	}
	
	public List<News> getAllNews() 
	{
		return usersdao.getAllNews();
	}
	
	
	public Users findByEmail(String email) 
	{
		
		return usersdao.findByEmail(email);
	} 
	
	
	public int generateOtp() 
	{
		Random random = new Random();
		int num = random.nextInt(99999) + 99999;
		if (num < 100000 || num > 999999) 
		{
			num = random.nextInt(99999) + 99999;
			if (num < 100000 || num > 999999)
			{
				System.out.println("Unable to generate PIN at this time..");
			}
		}
		return num;
		
	}
	
	


	public Account checkBalance(int uid)
	{
		return usersdao.checkBalance(uid);
	
	}


	public Users getSpecificUser(int parseInt)
	{
		return (Users) usersdao.getSpecificUser(parseInt);
	}
	
	
	public String updateCustomerDetails(int uid, Users u) {
		// confirm if emp exists
		Users u1 = (Users) usersdao.getSpecificUser(uid);
		if (u1 == null)
			throw new RuntimeException("Emp ID invalid");
		// update

		u.setId(u1.getId());
		return usersdao.updateCustomerDetails(uid,u);
	}
	
	
      public Users getUserDetails(int uid)
      {
		
	 return usersdao.getUserDetails(uid);
		
	}

      
      public String updateuserprofile(Integer id,Users user)

      {
   	  System.out.println("in update profile of memservice");
    	  Users find=usersdao.findById(id);
    	  user.setId(find.getId());
    	  usersdao.updateprofile(user);
    	  return "mem ser ";
    	  
      }
	
      
      public Users getData(Integer id)
      {
    	  System.out.println("in getData");
    	  return usersdao.findById(id);
      }
      

 
      
      
      
      public Integer signupUser(Users user)
  	{
  		return usersdao.signupUser(user);
  	}

      public Integer createAccount(Account acc)
    	{
//    	  System.out.println("in create acc");
//    	  acc.setAcc_type(acc.getAcc_type());
//    	  acc.setAccount_no(acc.getAccount_no());
//    	  acc.setBalance(acc.getBalance());
    		return usersdao.createAccount(acc);
    	}

      public	Users getUserAccountDetailsList(int uid)
  	{
  		return usersdao.getUserAccountDetailsList(uid);
  	
  	}

  	public	List<Users> findByRole(Role r)
  	{
  		return usersdao.findByRole(r);
  	
  	}
     
  	
  	public String deleteUsers(int uid) 
  	{
		Users u = usersdao.getUserDetails(uid);
		if (u == null)
			throw new RuntimeException("user ID invalid");

		return usersdao.deleteUsers(u);
	}

  	
  	
    public String editByAdmin(Integer id,Users user)

    {
 	  System.out.println("in update profile of Admin service");
  	  Users find=usersdao.findById(id);
  	  user.setId(find.getId());
  	  usersdao.editByAdmin(user);
  	  return "user updated by admin ";
  	  
    }


	public void tranfertoAccount(AccountTransfer acc) {
		System.out.println(acc);
		usersdao.acctransfer(Integer.parseInt(acc.getAccount_no()),Integer.parseInt(acc.getTo_account()),Double.parseDouble(acc.getAmount()));
		
	}
  	
	
	public List<Users> getManager()
	{
		return usersdao.getManager();
	}





}
