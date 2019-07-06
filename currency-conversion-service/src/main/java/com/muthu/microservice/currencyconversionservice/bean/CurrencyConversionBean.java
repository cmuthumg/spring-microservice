package com.muthu.microservice.currencyconversionservice.bean;

import java.math.BigDecimal;


public class CurrencyConversionBean {
	
	private int id;
	private String from;
	private String to;
	private BigDecimal conversionMutiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculationAmount;
	private int port;
	
	public CurrencyConversionBean(int id, String from, String to, BigDecimal conversionMutiple, BigDecimal quantity,
			BigDecimal totalCalculationAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMutiple = conversionMutiple;
		this.quantity = quantity;
		this.totalCalculationAmount = totalCalculationAmount;
		this.port = port;
	}
	public CurrencyConversionBean() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMutiple() {
		return conversionMutiple;
	}
	public void setConversionMutiple(BigDecimal conversionMutiple) {
		this.conversionMutiple = conversionMutiple;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalculationAmount() {
		return totalCalculationAmount;
	}
	public void setTotalCalculationAmount(BigDecimal totalCalculationAmount) {
		this.totalCalculationAmount = totalCalculationAmount;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

}
