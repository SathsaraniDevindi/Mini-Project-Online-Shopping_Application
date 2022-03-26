package com.example.Online.Shopping.Application;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineShoppingApplicationTests {

	@Test
	void contextLoads() {
		String main = "Main Application";
		Assert.assertEquals("Main Application",main);
	}

}
