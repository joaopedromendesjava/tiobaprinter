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
@Table(name = "toner")
public class Toner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "model_id")
	private TonerModel model;

	private Long codeRef;
	
	public Toner() {
	
	}

	public Toner(Long id, TonerModel model, Long codeRef) {
		this.id = id;
		this.model = model;
		this.codeRef = codeRef;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TonerModel getModel() {
		return model;
	}

	public void setModel(TonerModel model) {
		this.model = model;
	}

	public Long getCodeRef() {
		return codeRef;
	}

	public void setCodeRef(Long codeRef) {
		this.codeRef = codeRef;
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
		Toner other = (Toner) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
