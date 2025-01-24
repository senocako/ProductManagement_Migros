package com.migros.product_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class ProductManagementApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(ProductManagementApplication.class, args);
	}

}
