package com.mohitpuranik.challenge.model;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class PrimeNumbers {
	
	public Integer initial;
	public Integer[] primes;
	
}
