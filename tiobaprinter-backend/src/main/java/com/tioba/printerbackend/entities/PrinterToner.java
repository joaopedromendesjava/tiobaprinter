package com.tioba.printerbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "printer_toner")
public class PrinterToner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Printer printer;

	@ManyToOne(fetch = FetchType.LAZY)
	private Toner toner;
	
	private Integer using;
	
	public PrinterToner() {
	
	}

	public PrinterToner(Integer id, Printer printer, Toner toner, Integer using) {
		this.id = id;
		this.printer = printer;
		this.toner = toner;
		this.using = using;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getUsing() {
		return using;
	}

	public void setUsing(Integer using) {
		this.using = using;
	}
	
	
}
