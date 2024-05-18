package com.tioba.printerbackend.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

import com.tioba.printerbackend.entities.MaintenanceOrder;
import com.tioba.printerbackend.entities.Printer;
import com.tioba.printerbackend.entities.enums.StatusMaintenance;

public class MaintenanceOrderDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Printer printer;
	private LocalDateTime openingDate;
	private LocalDateTime closeDate;
	private String description;
	private StatusMaintenance status;

	public MaintenanceOrderDTO() {
	
	}

	public MaintenanceOrderDTO(Long id, Printer printer, LocalDateTime openingDate, LocalDateTime closeDate,
			String description, StatusMaintenance status, Instant created_At, Instant updated_At) {
		this.id = id;
		this.printer = printer;
		this.openingDate = openingDate;
		this.closeDate = closeDate;
		this.description = description;
		this.status = status;
	}

	public MaintenanceOrderDTO(MaintenanceOrder maintenanceOrder) {
		this.id = maintenanceOrder.getId();
		this.printer = maintenanceOrder.getPrinter();
		this.openingDate = maintenanceOrder.getOpeningDate();
		this.closeDate = maintenanceOrder.getCloseDate();
		this.description = maintenanceOrder.getDescription();
		this.status = maintenanceOrder.getStatus();
	}
	
	public MaintenanceOrderDTO(MaintenanceOrder maintenanceOrder, Printer printer) {
		this(maintenanceOrder);
		this.setPrinter(printer);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public LocalDateTime getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}

	public LocalDateTime getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(LocalDateTime closeDate) {
		this.closeDate = closeDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StatusMaintenance getStatus() {
		return status;
	}

	public void setStatus(StatusMaintenance status) {
		this.status = status;
	}
}




