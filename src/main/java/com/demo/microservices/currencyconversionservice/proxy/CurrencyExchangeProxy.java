package com.demo.microservices.currencyconversionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.microservices.currencyconversionservice.entity.CurrencyConverter;

// @FeignClient(name = "currency-exchange" , url = "http://localhost:8000")
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConverter retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}
