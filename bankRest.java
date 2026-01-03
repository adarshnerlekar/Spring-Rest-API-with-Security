 package com.springRestdatabase3.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springRestdatabase3.Service.bankService;
import com.springRestdatabase3.entity.BankAccount;
import com.springRestdatabase3.entity.balance;
@RestController
public class bankRest 
{
	@Autowired
	 bankService bankService;
	
	
	@DeleteMapping("bankDelete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id)
	{
		String msg = bankService.Delete(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	
	
	@PatchMapping("balanceUpdate/{id}")
	public ResponseEntity<String> updateBalance(@PathVariable Integer id,@RequestBody balance balance)
	{
		String msg = bankService.updatebalance(id, balance);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PutMapping("bankUpdate")
	public ResponseEntity<String> update1(@RequestParam Integer id, @RequestBody BankAccount account)
	{
		String msg = bankService.UpdateBankDetails(id,account);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	
	@PutMapping("bankUpdate/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody BankAccount account)
	{
		String msg = bankService.UpdateBankDetails(id,account);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	
	 @GetMapping("findall")
	public ResponseEntity<List<BankAccount>> findall()
	{
		List<BankAccount> Bankaccounts = bankService.findAll();
		return new ResponseEntity<List<BankAccount>>(Bankaccounts,HttpStatus.CREATED);
	}
	
	
	
	 @PostMapping("bankRest")
	public  ResponseEntity<String> SaveBankDetailes(@RequestBody BankAccount account)
	{
		String Detailes = bankService.savebankDetailes(account);
		return new ResponseEntity<String>(Detailes, HttpStatus.ACCEPTED);
	}
	 
	 @GetMapping("getbank/{id}")
	 public BankAccount bankService(@PathVariable Integer id)
	 {
		  return bankService.findByID(id);

	 }

	 @GetMapping("getbank")
	 public BankAccount bankService1(@RequestParam Integer id)
	 {
		  return bankService.findByID(id);
	 }

}
