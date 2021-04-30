package com.mohitpuranik.challenge.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class PrimeNumberServiceImpl implements PrimeNumberService {

	@Override
	public List<Integer> findPrimNumbersTill(int maxNumber) {

		return IntStream.rangeClosed(0, maxNumber).filter(this::isPrime).boxed().collect(Collectors.toList());
	}

	private boolean isPrime(int num) {
		boolean isPrimeNumber = false;
		if(num >= 2) {
			for(int i=2; i <= num; i++) {
				if( i != num && num % i == 0 ) {
					isPrimeNumber = false;
					break;
				} else {
					isPrimeNumber = true;
				}
			} 
		}
		return isPrimeNumber;
	}
}