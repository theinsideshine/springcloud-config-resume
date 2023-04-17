package com.theinsideshine.springcloud.msvc.sections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsvcSectionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcSectionsApplication.class, args);
	}

}
