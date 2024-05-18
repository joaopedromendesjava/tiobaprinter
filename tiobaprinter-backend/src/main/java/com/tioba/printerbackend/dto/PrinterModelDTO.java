package com.tioba.printerbackend.dto;

import com.tioba.printerbackend.entities.PrinterModel;

public class PrinterModelDTO {

	private String name;
	
	public PrinterModelDTO() {
	
	}
	
	public PrinterModelDTO(String name) {
		this.name = name;
	}
	
	public PrinterModelDTO(PrinterModel model) {
		this.name = model.getName();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
