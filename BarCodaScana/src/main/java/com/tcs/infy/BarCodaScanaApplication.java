package com.tcs.infy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcs.infy.service.EanCodeService;

@SpringBootApplication
public class BarCodaScanaApplication implements CommandLineRunner  {
	
	@Autowired
	EanCodeService eanCodeService;

	public static void main(String[] args) {
		SpringApplication.run(BarCodaScanaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(eanCodeService.saveItem().toString());
		
	}

}
