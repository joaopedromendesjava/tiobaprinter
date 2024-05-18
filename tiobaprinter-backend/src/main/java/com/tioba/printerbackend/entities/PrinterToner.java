package com.tioba.printerbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "printer_toner")
public class PrinterToner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "printer_id")
	private Printer printer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "toner_id")
	private Toner toner;
	
	private Integer status;
	
	public PrinterToner() {
	
	}

	public PrinterToner(Long id, Printer printer, Toner toner, Integer status) {
		this.id = id;
		this.printer = printer;
		this.toner = toner;
		this.status = status;
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

	public Toner getToner() {
		return toner;
	}

	public void setToner(Toner toner) {
		this.toner = toner;
	}

	public Integer getstatus() {
		return status;
	}

	public void setstatus(Integer status) {
		this.status = status;
	}
	
	
}
