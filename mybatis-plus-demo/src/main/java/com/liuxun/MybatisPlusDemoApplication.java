package com.liuxun;

import com.liuxun.factory.CustomMapperFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan(basePackages = {"com.liuxun.mapper"}, factoryBean = CustomMapperFactoryBean.class)
@MapperScan(basePackages = {"com.liuxun.mapper"})
@SpringBootApplication
public class MybatisPlusDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusDemoApplication.class, args);
	}

}
