package com.ty.mySpringBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ty.mySpringBank.model.Transaction;
import com.ty.mySpringBank.model.Account;
import com.ty.mySpringBank.service.AccountService;

@Controller
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountService service;

	@GetMapping("/create")
	public String showCreateAccount(Model model) {
		model.addAttribute("account", new Account());
		return "create-account";
	}

	@PostMapping("/create")
	public String createAccount(@ModelAttribute Account account) {
		System.out.println(account);
		service.createAccount(account);
		return "redirect:/accounts/create";
	}

	@GetMapping("/deposit")
	public String showDepositForm() {
		return "deposit";
	}

	@PostMapping("/deposit")
	public String deposit(@RequestParam String accountNumber, @RequestParam double amount) {
		service.deposit(accountNumber, amount);
		return "redirect:/accounts/deposit";
	}

	@GetMapping("/withdraw")
	public String showWithDrawForm() {
		return "withdraw";
	}

	@PostMapping("/withdraw")
	public String withdraw(@RequestParam String accountNumber, @RequestParam double amount) {
		service.withdraw(accountNumber, amount);
		return "redirect:/accounts/withdraw";
	}

	@GetMapping("/transaction")
	public String showgetTransactionform() {
		return "transaction";
	}

	@PostMapping("/transaction")
	public String getTransaction(@RequestParam String accountNumber, Model model) {
		List<Transaction> list = service.getTransactions(accountNumber);
		model.addAttribute("transaction", list);
		return "transactionform";
	}

}
