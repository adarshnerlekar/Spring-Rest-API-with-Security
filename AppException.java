package com.springRestdatabase3.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class AppException 
{
	@org.springframework.web.bind.annotation.ExceptionHandler
 public  ResponseEntity<bankError> ExceptionHandler(Exception e)
   {
	    bankError bank=new bankError();
	    bank.setMsg(e.getMessage());
	    bank.setTimedate(LocalDateTime.now());
	    return new ResponseEntity<bankError>(bank,HttpStatus.INTERNAL_SERVER_ERROR);
   }
}
