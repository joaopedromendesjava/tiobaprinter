package com.tioba.printerbackend.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.tioba.printerbackend.entities.Maintenance;
import com.tioba.printerbackend.entities.Printer;
import com.tioba.printerbackend.entities.PrinterModel;

public class PrinterDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Double price;
	private Instant updated_At;
	private Integer status;
	
	private List<MaintenanceDTO> maintenances = new ArrayList<>(); 
	private PrinterModel model;
	
	public PrinterDTO() {

	}

	public PrinterDTO(Long id, PrinterModel model, Double price, Instant updated_At, Integer status) {
		this.id = id;
		this.price = price;
		this.updated_At = updated_At;
		this.status = status;
	}
	
	public PrinterDTO(Printer printer) {
		this.id = printer.getId();
		this.price = printer.getPrice();
		this.updated_At = printer.getUpdated_At();
		this.status = printer.getStatus();
	}
	
	public PrinterDTO(Printer printer, List<Maintenance> maintenances, PrinterModel model) {
		this(printer);
		this.setModel(model);
		maintenances.forEach(m -> this.maintenances.add(new MaintenanceDTO(m)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PrinterModel getModel() {
		return model;
	}

	public void setModel(PrinterModel model) {
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
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getStatus() {
		return status;
	}
}
