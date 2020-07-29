package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.News;
import com.app.pojos.Users;

@Repository
@Transactional
public class AdminDaoImpl implements IAdminDao{

	public AdminDaoImpl() {
	System.out.println("in Admin dao");
	}
	
	
	@Autowired
	private SessionFactory sf;
	
	
//	@Override
//	public String addNews(News n) {
//		Integer Id=(Integer) sf.getCurrentSession().save(n);
//		
//		
//		return "news added";
//	}

	@Override
	public News findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public News getSpecificNews(int parseInt) {
		return sf.getCurrentSession().get(News.class,parseInt);
	}
	
	@Override
	public String updateNews(int nid, News n) {
		sf.getCurrentSession().saveOrUpdate(n);
		return "News details updated....";
	}

	@Override
	public String deleteNews(News n) {
		sf.getCurrentSession().delete(n);
		return "Deleted news info";
	}

}
