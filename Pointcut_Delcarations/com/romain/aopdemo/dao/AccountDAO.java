package com.romain.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.romain.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
		
	public boolean doWork() {
		System.out.println(getClass() + ": I AM DOING WORK");
		return false;
	}

}
