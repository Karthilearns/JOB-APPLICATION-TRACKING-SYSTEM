package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTrackingSystemApplicationTests {

	Calculator cal = new Calculator();
	
	@Test
	void add() {
		int t = cal.add(2,5);
		
		assertThat(t).isEqualTo(7);
	     
		
	}
	
	class Calculator{
		public int add(int a, int b) {
			return a+b;
		}
	}

}
