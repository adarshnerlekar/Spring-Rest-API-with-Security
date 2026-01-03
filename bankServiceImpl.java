package com.springRestdatabase3.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springRestdatabase3.Exception.bankIDNotFoundException;
import com.springRestdatabase3.Repositry.bankRepositry;
import com.springRestdatabase3.Service.bankService;
import com.springRestdatabase3.entity.BankAccount;
import com.springRestdatabase3.entity.balance;
@Service
public class bankServiceImpl implements bankService {
	@Autowired
	bankRepositry bankRepositry;
	
	@Override
	public String savebankDetailes(BankAccount account)
	{
		
		bankRepositry.save(account);
	    return "bank Detailes Save Sucessfully";
		
	}

	@Override
	public BankAccount findByID(Integer id) 
	{
		Optional<BankAccount> byId = bankRepositry.findById(id);
		if(byId.isPresent())
		{
			return byId.get();
		}
		throw new bankIDNotFoundException("Bank Account Not Find ID :"+id);
		
	}

	@Override
	public List<BankAccount> findAll()
	{
		return bankRepositry.findAll();
	}

	@Override
	public String UpdateBankDetails(Integer id, BankAccount account) {
		Optional<BankAccount> byId = bankRepositry.findById(id);
		if(byId.isPresent())
		{
			BankAccount bankAccount = byId.get();
			bankAccount.setName(account.getName());
			bankAccount.setAccountType(account.getAccountType());
			bankAccount.setBalance(account.getBalance());
			bankAccount.setGender(account.getGender());
			bankAccount.setAccountId(account.getAccountId());
			bankRepositry.save(bankAccount);
			return "bank Account Update Sucessfully";
		}
		throw new bankIDNotFoundException("Bank Account Not Find ID :"+id);
	}

	@Override
	public String updatebalance(Integer id, balance balance) {
		Optional<BankAccount> byId = bankRepositry.findById(id);
		if(byId.isPresent())
		{
			BankAccount bankAccount = byId.get();
			bankAccount.setBalance(balance.getBalance());
			bankRepositry.save(bankAccount);
			return "Balance Update Suessfully";
		}
		throw new bankIDNotFoundException("Bank Account Not Find ID :"+id);
	}

	@Override
	public String Delete(Integer id) {
		boolean existsById = bankRepositry.existsById(id);
		if(existsById==true)
		{
			bankRepositry.deleteById(id);
			return "Delete BankAccount Details";
		}
		throw new bankIDNotFoundException("Bank Account Not Find ID :"+id);
	}

}
