package com.springRestdatabase3.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class bankIDNotFoundException extends RuntimeException 
{
	
	public bankIDNotFoundException( String msg) {
		super(msg);
	}

}
