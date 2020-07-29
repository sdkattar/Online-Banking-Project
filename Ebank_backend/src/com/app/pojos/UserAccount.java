package com.app.pojos;

import java.util.Date;

public class UserAccount {
	private String name;
	private String mobileno;
	private String email;
	private String password;
	private String confirmpassword;
	private String pan;
	private String address;
	private AccountType acc_type;
	private Date opening_date;
	private double balance;
	private Role role;
	
	public UserAccount() {
System.out.println("in userAccount ctor");
	}
	
	
//
//	public UserAccount(String name2, String mobileno2, String email2, String password2, String confirmpassword2,
//			String address2) {
//		this.name=name2;
//		this.mobileno=mobileno2;
//		this.email=email2;
//		this.password=password2;
//		this.confirmpassword=confirmpassword2;
//		this
//		
//	}

	public UserAccount(String name, String mobileno, String email, String password, String confirmpassword, String pan,
			String address, AccountType acc_type, Date opening_date, double balance, Role role) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.pan = pan;
		this.address = address;
		this.acc_type = acc_type;
		this.opening_date = opening_date;
		this.balance = balance;
		this.role = role;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AccountType getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(AccountType acc_type) {
		this.acc_type = acc_type;
	}

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
	
	

	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "UserAccount [name=" + name + ", mobileno=" + mobileno + ", email=" + email + ", password=" + password
				+ ", confirmpassword=" + confirmpassword + ", pan=" + pan + ", address=" + address + ", acc_type="
				+ acc_type + ", opening_date=" + opening_date + ", balance=" + balance + "]";
	}
	
	
	
	
}
