package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Users {

	private Integer id;
	private String name;
	private String mobileno;
	private String email;
	private Role role;
	private String password;
	private String confirmpassword;
	private String pan;
	private String address;
	
	
	private List<Account> account=new ArrayList<>();
	
	
	private int otp;
	
	public Users() {
		// TODO Auto-generated constructor stub
		System.out.println("in users ctor");
	}
	
	
	


	public Users(int otp,String password ) {
		super();
		this.otp = otp;
		this.password = password;
		
	}





	public Users(String name, String mobileno, String email, String password, String pan, String address) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.email = email;
		this.password = password;
		this.pan = pan;
		this.address = address;
	}





	public Users(String name, String mobileno, String email, Role role, String password,String confirmpassword,
			String pan, String address) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.email = email;
		this.role = role;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.pan = pan;
		this.address = address;
	}




     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	@OneToMany(mappedBy="owner",cascade=CascadeType.ALL,orphanRemoval=true,fetch = FetchType.EAGER)
	 public List<Account> getAccount() {
		return account;
	}





	public void setAccount(List<Account> account) {
		this.account = account;
	}





	@Column(nullable=false)
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

    @Column(nullable=false)
	public String getMobileno() {
		return mobileno;
	}


	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	@Column(unique=true,nullable=false)
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


     @Enumerated(EnumType.STRING)
	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	@Column(nullable=false)
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

//	@Transient
	@Column
	public String getConfirmpassword() {
		return confirmpassword;
	}


	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

    
	@Column(nullable=false)
	public String getPan() {
		return pan;
	}


	public void setPan(String pan) {
		this.pan = pan;
	}


	@Column(nullable=false)
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	


	
    //@Transient
	public int getOtp()
    {
		return otp;
	}





	public void setOtp(int otp) {
		this.otp = otp;
	}


	public void addAccount(Account a)
	{
		account.add(a);
		a.setOwner(this);
	}




	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", email=" + email + ", role=" + role
				+ ", password=" + password + ", confirmpassword=" + confirmpassword + ", pan=" + pan + ", address="
				+ address + "]";
	}
	
	
	
	
}

