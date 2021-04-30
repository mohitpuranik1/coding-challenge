package com.mohitpuranik.challenge.controller;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.mohitpuranik.challenge.service.PrimeNumberService;

@SpringBootTest
@AutoConfigureMockMvc
public class PrimeNumberControllerTest {
	
	@Autowired
	private PrimeNumberController primeNumberController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PrimeNumberService primeNumberService;
	
	@Test
	public void test() throws Exception {
		mockMvc.perform(get("/api/prime/numbers/30"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("primes").isArray())
		.andExpect(jsonPath("primes", hasItems(7, 19, 29)));
	}
}
