package com.liuxun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.liuxun.mapper"})
@SpringBootApplication
public class MPMultiDsTransactionApp {

	public static void main(String[] args) {
		SpringApplication.run(MPMultiDsTransactionApp.class, args);
	}

}
