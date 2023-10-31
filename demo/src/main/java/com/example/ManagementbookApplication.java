
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("java.com.example")
public class ManagementbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementbookApplication.class, args);
	}

}
