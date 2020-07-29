package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Account {

	private Integer account_no;
	
	private AccountType acc_type;
	private Date opening_date;
	private double balance;

	@JsonBackReference
	private Users owner;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(AccountType acc_type, Date opening_date, double balance) {
		super();
		this.acc_type = acc_type;
		this.opening_date = opening_date;
		this.balance = balance;
	}

	
	
	public Account(AccountType acc_type, Date opening_date, double balance, Users owner) {
		super();
		this.acc_type = acc_type;
		this.opening_date = opening_date;
		this.balance = balance;
		this.owner = owner;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @SequenceGenerator(initialValue = 1000, name = "acc")
	// @TableGenerator(initialValue = 1000, name = "acc")
	public Integer getAccount_no() {
		return account_no;
	}

	public void setAccount_no(Integer account_no) {
		this.account_no = account_no;
	}

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public AccountType getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(AccountType acc_type) {
		this.acc_type = acc_type;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public Users getOwner() {
		return owner;
	}

	public void setOwner(Users owner) {
		this.owner = owner;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	public Date getOpening_date() {
		return opening_date;
	}

	public void setOpening_date(Date opening_date) {
		this.opening_date = opening_date;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [account_no=" + account_no + ", acc_type=" + acc_type + ", opening_date=" + opening_date
				+ ", balance=" + balance + "]";
	}

}
