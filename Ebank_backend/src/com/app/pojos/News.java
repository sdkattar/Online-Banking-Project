package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class News {

	private Integer news_id;
	private String title;
	
	public News() {
		System.out.println("in News ctor");
	}

	public News(String title) {
		super();
		this.title = title;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getNews_id() {
		return news_id;
	}

	public void setNews_id(Integer news_id) {
		this.news_id = news_id;
	}
	
    @Column
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	
	@Override
	public String toString() {
		return "News [news_id=" + news_id + ", title=" + title + "]";
	}
	
	
	
}
