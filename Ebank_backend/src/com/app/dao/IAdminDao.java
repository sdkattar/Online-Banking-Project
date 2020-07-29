package com.app.dao;

import java.util.List;



import com.app.pojos.Account;
import com.app.pojos.News;
import com.app.pojos.Role;
import com.app.pojos.Users;

public interface IAdminDao{

	//Integer addNews(News n);
	
	public News findById(Integer id);

	News getSpecificNews(int parseInt);
	String updateNews(int nid,News n);
	
	String deleteNews(News n);

	
	
	



	
	

}
