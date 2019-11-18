package com.example.challenge;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.challenge.ChallengeApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChallengeApplication.class)
@TestPropertySource(locations="classpath:test.properties")
class ChallengeApplicationTests {
	
	@Test
	public void contextLoads() {
		
	}
	
}
