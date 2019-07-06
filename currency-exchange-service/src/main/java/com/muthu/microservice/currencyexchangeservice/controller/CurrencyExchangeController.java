package com.muthu.microservice.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.muthu.microservice.currencyexchangeservice.bean.ExchangeValue;
import com.muthu.microservice.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;

	@Autowired
	private ExchangeValueRepository repo;

	@GetMapping("/currency-exchange/from/{from}/to/{to}/")
	public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {
		// ExchangeValue ev = new ExchangeValue(1000, from, to, BigDecimal.valueOf(65));
		ExchangeValue ev = repo.findByFromAndTo(from, to);
		ev.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return ev;
	}

}
