package com.app.pojos;

public class AccountTransfer {
	
	private String account_no;
	private String to_account;
	private String amount;
	
	
	public AccountTransfer() {
		
	}


	public AccountTransfer(String account_no, String to_account, String amount) {
		super();
		this.account_no = account_no;
		this.to_account = to_account;
		this.amount = amount;
	}


	public String getAccount_no() {
		return account_no;
	}


	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}


	public String getTo_account() {
		return to_account;
	}


	public void setTo_account(String to_account) {
		this.to_account = to_account;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "AccountTransfer [account_no=" + account_no + ", to_account=" + to_account + ", amount=" + amount + "]";
	}
	
	

}
