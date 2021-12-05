package com.demo.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.currencyconversionservice.entity.CurrencyConverter;

@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverter calculateConversionValue(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) throws Exception

	{
		return new CurrencyConverter(10001, from, to, BigDecimal.valueOf(10), quantity, BigDecimal.valueOf(200), "");
	}
}
