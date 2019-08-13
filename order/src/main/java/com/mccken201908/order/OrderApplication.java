package com.mccken201908.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Import;

import com.mccken201908.order.config.DynamicDataSourceConfig;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.mccken201908.order.dao")
@Import({DynamicDataSourceConfig.class})
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}
