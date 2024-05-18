package com.tioba.printerbackend.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Maintenance implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "maintenance_order_id")
	private MaintenanceOrder maintenanceOrder;
	
	private Double totalValue;
	
	@Column(name = "maintenance_date")
	@Temporal(TemporalType.DATE)
	private LocalDate maintenanceDate;
	
	@Column(name = "end_warranty")
	@Temporal(TemporalType.DATE)
	private LocalDate endWarranty;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp(source = SourceType.DB)
	private Instant created_At;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp(source = SourceType.DB)
	private Instant updated_At;
	
	
	public Maintenance() {
	
	}

	public Maintenance(Long id, MaintenanceOrder maintenanceOrder, Double totalValue, LocalDate maintenanceDate,
			LocalDate endWarranty, Instant created_At, Instant updated_At) {
		this.id = id;
		this.maintenanceOrder = maintenanceOrder;
		this.totalValue = totalValue;
		this.maintenanceDate = maintenanceDate;
		this.endWarranty = endWarranty;
		this.created_At = created_At;
		this.updated_At = updated_At;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MaintenanceOrder getMaintenanceOrder() {
		return maintenanceOrder;
	}

	public void setMaintenanceOrder(MaintenanceOrder maintenanceOrder) {
		this.maintenanceOrder = maintenanceOrder;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public LocalDate getMaintenanceDate() {
		return maintenanceDate;
	}

	public void setMaintenanceDate(LocalDate maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
	}

	public LocalDate getEndWarranty() {
		return endWarranty;
	}

	public void setEndWarranty(LocalDate endWarranty) {
		this.endWarranty = endWarranty;
	}

	public Instant getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Instant updated_At) {
		this.updated_At = updated_At;
	}

	public Instant getCreated_At() {
		return created_At;
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
