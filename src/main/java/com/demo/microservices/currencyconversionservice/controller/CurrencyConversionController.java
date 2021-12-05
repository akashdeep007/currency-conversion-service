package com.demo.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.microservices.currencyconversionservice.entity.CurrencyConverter;

@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverter calculateConversionValue(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) throws Exception

	{
//		return new CurrencyConverter(10001, from, to, BigDecimal.valueOf(10), quantity, BigDecimal.valueOf(200), "");
		HashMap<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConverter> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConverter.class, uriVariables);
		CurrencyConverter currencyConverter = responseEntity.getBody();
		currencyConverter.setQuantity(quantity);
		BigDecimal conversionMultiple = currencyConverter.getConversionMultiple();
		currencyConverter.setConvertedValue(quantity.multiply(conversionMultiple));
		return currencyConverter;
	}
}
