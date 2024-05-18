package com.tioba.printerbackend.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.tioba.printerbackend.entities.MaintenanceOrder;
import com.tioba.printerbackend.entities.Printer;
import com.tioba.printerbackend.entities.PrinterModel;
import com.tioba.printerbackend.entities.enums.StatusPrinter;

public class PrinterDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Double price;
	private Instant updated_At;
	private StatusPrinter status;
	private Set<MaintenanceOrderDTO> maintenances = new HashSet<>();
	private PrinterModel model;
	
	public PrinterDTO() {

	}

	public PrinterDTO(Long id, PrinterModel model, Double price, Instant updated_At, StatusPrinter status) {
		this.id = id;
		this.price = price;
	//	this.updated_At = updated_At;
		this.status = status;
		this.model = model;
	}
	
	public PrinterDTO(Printer printer) {
		this.id = printer.getId();
		this.price = printer.getPrice();
		//this.updated_At = printer.getUpdated_At();
		this.status = printer.getStatus();
		this.model = printer.getModel();
	}
	
	public PrinterDTO(Printer printer, Set<MaintenanceOrder> maintenances, PrinterModel model) {
		this(printer);
		this.setModel(model);
		maintenances.forEach(m -> this.maintenances.add(new MaintenanceOrderDTO(m)));
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
	
	public void setStatus(StatusPrinter status) {
		this.status = status;
	}
	
	public StatusPrinter getStatus() {
		return status;
	}
	
}
