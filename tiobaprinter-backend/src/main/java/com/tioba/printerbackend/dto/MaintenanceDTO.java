package com.tioba.printerbackend.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.tioba.printerbackend.entities.Maintenance;
import com.tioba.printerbackend.entities.Printer;

public class MaintenanceDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String text;
	private Double price;
	private LocalDateTime maitenanceShippingDate;
	private LocalDate endWarranty;
	private Instant updated_At;
	
	private Printer printer;
	
	public MaintenanceDTO() {
	
	}

	public MaintenanceDTO(Long id, String text, Double price, LocalDateTime maitenanceShippingDate,
			LocalDate endWarranty, Instant updated_At) {
		this.id = id;
		this.text = text;
		this.price = price;
		this.maitenanceShippingDate = maitenanceShippingDate;
		this.endWarranty = endWarranty;
		this.updated_At = updated_At;
	}
	
	public MaintenanceDTO(Maintenance maintenance) {
		this.id = maintenance.getId();
		this.price = maintenance.getPrice();
		this.text = maintenance.getText();
		this.endWarranty = maintenance.getEndWarranty();
		this.updated_At = maintenance.getUpdated_At();
		this.maitenanceShippingDate = maintenance.getMaitenanceShippingDate();
	}
	public MaintenanceDTO(Maintenance maintenance, Printer printer) {
		this(maintenance);
		this.setPrinter(printer);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDateTime getMaitenanceShippingDate() {
		return maitenanceShippingDate;
	}

	public void setMaitenanceShippingDate(LocalDateTime maitenanceShippingDate) {
		this.maitenanceShippingDate = maitenanceShippingDate;
	}

	public LocalDate getEndWarranty() {
		return endWarranty;
	}

	public void setEndWarranty(LocalDate endWarranty) {
		this.endWarranty = endWarranty;
	}

	public Instant getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Instant updated_At) {
		this.updated_At = updated_At;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
}




