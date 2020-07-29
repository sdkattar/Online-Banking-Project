package com.app.dao;

import java.util.List;

import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Account;
import com.app.pojos.News;
import com.app.pojos.Role;
import com.app.pojos.Users;

@Repository
@Transactional
public class UsersDaoImpl implements IUsersDao{

	public UsersDaoImpl() {
	System.out.println("in user dao");
	}
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public Integer registerUser(Users users,Account a) {
////		users.addAccount(account);
//		users.addAccount(a);//u --dhetached , a--transient
//		System.out.println(users);
//		return (Integer) sf.getCurrentSession().save(users);
		
		Integer Id=(Integer) sf.getCurrentSession().save(users);
		Users useradded=sf.getCurrentSession().get(Users.class, Id);
		useradded.addAccount(a);
		
		return useradded.getId();
	}
	

	@Override
	public Users loginUser(Users users) {
		
		String jpql="select u from Users u where u.email=:em and u.password=:pass";
		Users uservalidate=null;
		
		try {
	
		uservalidate= sf.getCurrentSession().createQuery(jpql,Users.class).setParameter("em", users.getEmail()).setParameter("pass", users.getPassword()).getSingleResult();
		}
		
		catch(Exception e)
		{
			System.out.println("exception here");
		}
		
		return uservalidate;
	}

	
	
	@Override
	public 	List<Users> getAllUsers() {
		String jpql="select u from Users u join fetch u.account";
		
		List<Users> list= sf.getCurrentSession().createQuery(jpql, Users.class).getResultList();
		for(Users u : list)
			System.out.println(u);
		return list;
	}
	
	
	@Override
	public List<News> getAllNews() {
		String jpql="select u from News u";
		
		List<News> list= sf.getCurrentSession().createQuery(jpql, News.class).getResultList();
		for(News u : list)
			System.out.println(u);
		return list;
	}

	
	@Override
	public Users findByEmail(String email) {
		System.out.println("in dao "+email);
		String jpql="select u from Users u where u.email=:em";
		return sf.getCurrentSession().createQuery(jpql, Users.class).setParameter("em",email).getSingleResult();
		
	}

	@Override
      public void setPass(String pass, String email) {
		System.out.println("in dao setpass");
		String str = "select u from Users u where u.email=:em";
		Users u= sf.getCurrentSession().createQuery(str,Users.class).setParameter("em",email).getSingleResult();	
		System.out.println(u);	
		u.setPassword(pass);
	}

	
//	@Override
//	public Account checkBalance(int user_id) {
//	String jpql="select a.account_no,a.balance from Account a where a.user_id=:id";
//		
//		Account list= sf.getCurrentSession().createQuery(jpql, Account.class).setParameter("id",user_id).getSingleResult();
//	
//		return list;
//	}
	
	

	
	

	@Override
	public Account checkBalance(int uid) {
	String str = "select a from Account a where a.owner.id=:id";
	return	 sf.getCurrentSession().createQuery(str,Account.class).setParameter("id",uid).getSingleResult();	
		//return sf.getCurrentSession().get(Account.class,uid);
	}


	@Override
	public Users getSpecificUser(int parseInt) {
		return sf.getCurrentSession().get(Users.class,parseInt);
	}


	@Override
	public String updateCustomerDetails(int id,Users u) {
//		Users user=	sf.getCurrentSession().get(Users.class, id);
//		
//		u.setId(user.getId());
		sf.getCurrentSession().saveOrUpdate(u);
		return "customer details updated....";
	}

	
	

	@Override
	public Users getUserDetails(int uid) {
		
		return sf.getCurrentSession().get(Users.class, uid);
		
	}


//	@Override
//	public Users profile(Users user) {
//		String jpql="select u from Users u where u.email=:em";
//		Users u=sf.getCurrentSession().createQuery(jpql,Users.class).setParameter("em", user.getEmail()).getSingleResult();
//		u.setName(user.getName());
//		u.setMobileno(user.getMobileno());
//		//u.setEmail(user.getEmail());
//		u.setPassword(user.getPassword());
//		u.setPan(user.getPan());
//		u.setAddress(user.getAddress());
//		return user;
//	}


	@Override
	public String updateprofile(Users user) {
		System.out.println("in updateprofile");
	 sf.getCurrentSession().update(user);
	 return "user";
	}


	@Override
	public Users findById(Integer id) {
		System.out.println("findindoing user by id..");
		return sf.getCurrentSession().get(Users.class, id);
	}

	public Integer signupUser(Users users)
	{
	
		return (Integer) sf.getCurrentSession().save(users);
	  
	}


	@Override
	public Integer createAccount(Account account) {
		return (Integer) sf.getCurrentSession().save(account);
	}


	@Override
	public void addAcc(int id, Account acc) {
		Users user=sf.getCurrentSession().get(Users.class,id);
		user.addAccount(acc);
		
	}


	@Override
	public Users getUserAccountDetailsList(int uid) {
		String jpql="select u from Users u join fetch u.account where u.id=:uid";
		return sf.getCurrentSession().createQuery(jpql, Users.class).setParameter("uid", uid).getSingleResult();
		
		
	}


	@Override
	public List<Users> findByRole(Role r) {
		return (List<Users>) sf.getCurrentSession().get(Users.class, r);
		
	}


	@Override
	public String transaction(int uid) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String deleteUsers(Users u) {
		sf.getCurrentSession().delete(u);
		return "Deleted user info";
	}


	@Override
	public String editByAdmin(Users user) {
		System.out.println("in update by Admin");
		 sf.getCurrentSession().update(user);
		 return "updated successsfully by admin";
	}


	
	@Override
	public void acctransfer(int parseInt, int parseInt2, double parseDouble) {
		Account from=sf.getCurrentSession().get(Account.class, parseInt);
		Account to=sf.getCurrentSession().get(Account.class, parseInt2);
		from.setBalance(from.getBalance()-parseDouble);
		to.setBalance(to.getBalance()+parseDouble);
		
		
	}


	@Override
	public List<Users> getManager() {
     String jpql="select u from Users u where u.role='MANAGER'";
		
		List<Users> list= sf.getCurrentSession().createQuery(jpql, Users.class).getResultList();
		for(Users u : list)
			System.out.println(u);
		return list;
	}


	






//	@Override
//	public String transaction(int uid) {
//		String str = "select a from Account a where a.owner.id=:uid";
//		return null;
//	}



	

	
	
}


