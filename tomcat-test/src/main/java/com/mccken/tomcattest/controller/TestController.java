package com.mccken.tomcattest.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.tomcat.util.threads.TaskThread;
import org.apache.tomcat.util.threads.TaskThreadFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloudlearn
 * @description:
 * @author: mccken
 * @create: 2021-01-08 19:00
 **/
@RestController
public class TestController {

	private AtomicInteger atomicInteger = new AtomicInteger(0);

	@GetMapping("test1")
	public void test1() throws InterruptedException {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		String name = Thread.currentThread().getName();
		System.out.println(name + "：" + atomicInteger.getAndIncrement());
		Thread.sleep(5000);
		System.out.println("接收到了一个请求");
		stopWatch.stop();
//		System.out.println(stopWatch.getTotalTimeMillis());

	}

}
