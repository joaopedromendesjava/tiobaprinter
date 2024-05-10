package com.tioba.printerbackend.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Maintenance implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty(message = "Description is not empty")
	@Column(columnDefinition = "TEXT")
	private String text;
	private Double price;
	
	@Column(name = "maintenance_shipping_date")
	private LocalDateTime maitenanceShippingDate;
	
	@Column(name = "end_warranty")
	private LocalDate endWarranty;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant created_At;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updated_At;
	
	@ManyToOne
	@JoinColumn(name = "printer_id")
	private Printer printer;
	
	public Maintenance() {
	
	}

	public Maintenance(Long id, @NotNull @NotEmpty(message = "Description is not empty") String text, Double price,
			LocalDateTime maitenanceShippingDate, LocalDate endWarranty, Instant created_At, Instant updated_At,
			Printer printer) {
		
		this.id = id;
		this.text = text;
		this.price = price;
		this.maitenanceShippingDate = maitenanceShippingDate;
		this.endWarranty = endWarranty;
		this.created_At = created_At;
		this.updated_At = updated_At;
		this.printer = printer;
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

	public Instant getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Instant created_At) {
		this.created_At = created_At;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Maintenance other = (Maintenance) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
