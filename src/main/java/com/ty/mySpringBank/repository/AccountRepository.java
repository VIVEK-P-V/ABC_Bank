package com.ty.mySpringBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.mySpringBank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	public Account findByAccountNumber(String accountNumber);
}
