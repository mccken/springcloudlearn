package com.mccken201908.order.adapter;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DynamicDataSourceConfig {
	
	private DruidDataSource createCustomSource() {
		DruidDataSource dataSource = new DruidDataSource();
		List<Filter> filters = new ArrayList<Filter>();
		filters.add(new WallFilter());
		//注入拦截器
		filters.add(new MysqlFilter());
		filters.add(new StatFilter());
		dataSource.setProxyFilters(filters);
		return dataSource;
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DruidDataSource dataSource() {
		return createCustomSource();
	}
}
