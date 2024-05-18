package com.tioba.printerbackend.entities;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import com.tioba.printerbackend.entities.enums.StatusMaintenance;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "maintenance_order")
public class MaintenanceOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "printer_id")
	private Printer printer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "opening_date")
	private LocalDateTime openingDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "close_date")
	private LocalDateTime closeDate;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusMaintenance status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp(source = SourceType.DB)
	private Instant created_At;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp(source = SourceType.DB)
	private Instant updated_At;
	
	@OneToMany(mappedBy = "maintenanceOrder", cascade = CascadeType.ALL)
	private Set<Maintenance> maintenances = new HashSet<>();

	public MaintenanceOrder() {
	
	}

	public MaintenanceOrder(Long id, Printer printer, LocalDateTime openingDate, LocalDateTime closeDate,
			String description, StatusMaintenance status, Instant created_At, Instant updated_At) {

		this.id = id;
		this.printer = printer;
		this.openingDate = openingDate;
		this.closeDate = closeDate;
		this.description = description;
		this.status = status;
		this.created_At = created_At;
		this.updated_At = updated_At;
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

	public Instant getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Instant updated_At) {
		this.updated_At = updated_At;
	}

	public Instant getCreated_At() {
		return created_At;
	}
	
	public Set<Maintenance> getMaintenances() {
		return maintenances;
	}
	
	
}




