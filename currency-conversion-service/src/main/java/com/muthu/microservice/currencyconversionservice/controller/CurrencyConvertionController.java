package com.muthu.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.muthu.microservice.currencyconversionservice.CurrencyExchangeServiceProxy;
import com.muthu.microservice.currencyconversionservice.bean.CurrencyConversionBean;

@RestController
public class CurrencyConvertionController {

	@Autowired
	CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}/")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		// Call Currency exchange service
		// Fiegn Problem 1
		Map<String, String> uriVariable = new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}/", CurrencyConversionBean.class,
				uriVariable);

		CurrencyConversionBean reponse = responseEntity.getBody();

		return new CurrencyConversionBean(reponse.getId(), from, to, reponse.getConversionMutiple(), quantity,
				quantity.multiply(reponse.getConversionMutiple()), reponse.getPort());
	}

	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}/")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversionBean reponse = proxy.getExchangeValue(from, to);

		return new CurrencyConversionBean(reponse.getId(), from, to, reponse.getConversionMutiple(), quantity,
				quantity.multiply(reponse.getConversionMutiple()), reponse.getPort());
	}

}
