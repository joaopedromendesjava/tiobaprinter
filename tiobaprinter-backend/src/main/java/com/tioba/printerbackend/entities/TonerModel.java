package com.tioba.printerbackend.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

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
public class TonerModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty(message = "name to model is not empty")
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Instant created_At = Instant.now();
	
	@JsonIgnore
	@OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
	private Set<Toner> toners = new HashSet<>();
	
	public TonerModel() {
	
	}

	public TonerModel(Long id, @NotNull @NotEmpty(message = "name to model is not empty") String name ) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Set<Toner> getPrinters() {
		return toners;
	}
}
