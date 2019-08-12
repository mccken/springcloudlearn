package com.mccken201908.order;

import com.mccken201908.order.adapter.DynamicDataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.mccken201908.order.dao")
//@ImportResource({"classpath:druid2.properties"})
@Import({DynamicDataSourceConfig.class})
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
	
}
