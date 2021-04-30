package com.mohitpuranik.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohitpuranik.challenge.model.PrimeNumbers;
import com.mohitpuranik.challenge.service.PrimeNumberService;

@RestController
@RequestMapping("/api")
public class PrimeNumberController {
	
	@Autowired
	private PrimeNumberService primeNumberService;
	
	@GetMapping("/prime/numbers/{number}")
	public ResponseEntity<PrimeNumbers> getPrimeNumbers(@PathVariable("number") int number){
		
		List<Integer> primeNumbers = primeNumberService.findPrimNumbersTill(number);
		return ResponseEntity.ok(buildResponse(number, primeNumbers));
	}
	
	private PrimeNumbers buildResponse(int number, List<Integer> primNumbers) {
        return PrimeNumbers.builder()
                .initial(number)
                .primes(primNumbers.toArray(new Integer[0]))
                .build();
    }

}
