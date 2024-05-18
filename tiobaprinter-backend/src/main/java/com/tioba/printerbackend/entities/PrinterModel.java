package com.tioba.printerbackend.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "printer_model")
public class PrinterModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@NotEmpty(message = "name to model is not empty")
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Instant created_At = Instant.now();
	
	@JsonIgnore
	@OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
	private List<Printer> printers = new ArrayList<>();
	
	public PrinterModel() {
	
	}

	public PrinterModel(Integer id, @NotNull @NotEmpty(message = "name to model is not empty") String name ) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Instant created_At) {
		this.created_At = created_At;
	}

	public List<Printer> getPrinters() {
		return printers;
	}
}
