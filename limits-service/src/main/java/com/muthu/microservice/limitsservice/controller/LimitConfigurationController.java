package com.muthu.microservice.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muthu.microservice.limitsservice.controller.bean.Configuration;
import com.muthu.microservice.limitsservice.controller.bean.LimitConfiguration;

@RestController
public class LimitConfigurationController {
	
	@Autowired
	Configuration config;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitConfiguration() {
		return new LimitConfiguration(config.getMinimum(),config.getMaximum());
	}

}
