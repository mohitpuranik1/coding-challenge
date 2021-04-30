package com.mohitpuranik.challenge.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PrimeNumberServiceImplTest {
	
	@Autowired
	private PrimeNumberService primeNumberService;
	
	@Test
	public void testFindPrimeNumbers() {
		assertThat(primeNumberService.findPrimNumbersTill(10))
		.hasSameElementsAs(IntStream.of(2, 3, 5, 7).boxed().collect(Collectors.toList()));
	}

}
