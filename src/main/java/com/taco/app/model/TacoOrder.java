package com.taco.app.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class TacoOrder {

	@NotBlank(message = "Delivery Name is Mandatory")
	private String deliveryName;

	@NotBlank(message = "Delivery Street is Mandatory")
	private String deliveryStreet;

	@NotBlank(message = "Delivery City is Mandatory")
	private String deliveryCity;

	@NotBlank(message = "Delivery State is Mandatory")
	private String deliveryState;

	@NotBlank(message = "Delivery Zip is Mandatory")
	private String deliveryZip;

	@CreditCardNumber(message = "Not a valid credit card number")
	private String ccNumber;

	@Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Must be formatted MM/YY")
	private String ccExpiration;

	@Digits(integer = 3, fraction = 0, message = "Invalid CVV")
	private String ccCVV;

	private List<Taco> tacos = new ArrayList<>();

	public void addTaco(Taco taco) {
		this.tacos.add(taco);
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryStreet() {
		return deliveryStreet;
	}

	public void setDeliveryStreet(String deliveryStreet) {
		this.deliveryStreet = deliveryStreet;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public String getDeliveryZip() {
		return deliveryZip;
	}

	public void setDeliveryZip(String deliveryZip) {
		this.deliveryZip = deliveryZip;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcExpiration() {
		return ccExpiration;
	}

	public void setCcExpiration(String ccExpiration) {
		this.ccExpiration = ccExpiration;
	}

	public String getCcCVV() {
		return ccCVV;
	}

	public void setCcCVV(String ccCVV) {
		this.ccCVV = ccCVV;
	}

	public List<Taco> getTacos() {
		return tacos;
	}

	public void setTacos(List<Taco> tacos) {
		this.tacos = tacos;
	}

	@Override
	public String toString() {
		return "TacoOrder [deliveryName=" + deliveryName + ", deliveryStreet=" + deliveryStreet + ", deliveryCity="
				+ deliveryCity + ", deliveryState=" + deliveryState + ", deliveryZip=" + deliveryZip + ", ccNumber="
				+ ccNumber + ", ccExpiration=" + ccExpiration + ", ccCVV=" + ccCVV + ", tacos=" + tacos + "]";
	}

}
