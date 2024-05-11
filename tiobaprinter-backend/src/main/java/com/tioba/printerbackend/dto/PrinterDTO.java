package com.tioba.printerbackend.dto;

import java.io.Serializable;
import java.time.Instant;

import com.tioba.printerbackend.entities.Printer;

public class PrinterDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String model;
	private Double price;
	private Instant updated_At;
	
	public PrinterDTO() {

	}

	public PrinterDTO(Long id, String model, Double price, Instant updated_At) {
		this.id = id;
		this.model = model;
		this.price = price;
		this.updated_At = updated_At;
	}
	
	public PrinterDTO(Printer printer) {
		this.id = printer.getId();
		this.model = printer.getModel();
		this.price = printer.getPrice();
		this.updated_At = printer.getUpdated_At();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Instant getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Instant updated_At) {
		this.updated_At = updated_At;
	}
}
