package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IAdminDao;
import com.app.dao.IUsersDao;
import com.app.pojos.News;
import com.app.pojos.Users;

@Service
public class AdminService {

	AdminService()
	{
		System.out.println("in Admin service");
	}
	
	@Autowired
	private IAdminDao admindao;
	
	
	public News getSpecificNews(int parseInt)
	{
		return (News) admindao.getSpecificNews(parseInt);
	}
	
	public String updateNews(int uid, News n) {
		// confirm if emp exists
		News u1 = (News) admindao.getSpecificNews(uid);
		if (u1 == null)
			throw new RuntimeException("News ID invalid");
		// update

		n.setNews_id(u1.getNews_id());
		return admindao.updateNews(uid,n);
	}

	
	
}
