package com.tioba.printerbackend.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import com.tioba.printerbackend.entities.enums.StatusPrinter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Printer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "model_id")
	private PrinterModel model;
	
	private Double price;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusPrinter status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp(source = SourceType.DB)
	private Instant updated_At;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp(source = SourceType.DB)
	private Instant created_At = Instant.now();
	
	@OneToMany(mappedBy = "printer", cascade = CascadeType.ALL)
	Set<MaintenanceOrder> maintenancesOrders = new HashSet<>();
	
	public Printer() {
	
	}

	public Printer(Long id, @NotNull @NotEmpty(message = "model is not empty") PrinterModel model, Double price,
			Instant created_At, Instant updated_At, StatusPrinter status) {
		this.id = id;
		this.model = model;
		this.price = price;
		this.created_At = created_At;
		this.updated_At = updated_At;
		this.status = status;
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
	
	public void setStatus(StatusPrinter status) {
		this.status = status;
	}
	
	public StatusPrinter getStatus() {
		return status;
	}
	
	public Set<MaintenanceOrder> getMaintenances() {
		return maintenancesOrders;
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
		Printer other = (Printer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}




