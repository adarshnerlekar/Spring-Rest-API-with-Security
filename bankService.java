package com.springRestdatabase3.Service;

import java.util.List;

import com.springRestdatabase3.entity.BankAccount;
import com.springRestdatabase3.entity.balance;

public interface bankService  {
	
	String savebankDetailes(BankAccount account);
	BankAccount findByID(Integer id);
	List<BankAccount> findAll();
	String UpdateBankDetails(Integer id,BankAccount account);
	String updatebalance(Integer id,balance balance);
	String Delete(Integer id);

}
