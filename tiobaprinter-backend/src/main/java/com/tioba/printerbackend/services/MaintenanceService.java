package com.tioba.printerbackend.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tioba.printerbackend.dto.MaintenanceDTO;
import com.tioba.printerbackend.entities.Maintenance;
import com.tioba.printerbackend.entities.Printer;
import com.tioba.printerbackend.repositories.MaintenanceRepository;
import com.tioba.printerbackend.repositories.PrinterRepository;
import com.tioba.printerbackend.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;


@Service
public class MaintenanceService {

	@Autowired
	private MaintenanceRepository maintenanceRepository;
	
	@Autowired
	private PrinterRepository printerRepository;
	
	@Transactional(readOnly = true)
	public List<MaintenanceDTO> allMaintenances(){
		
		 List<Maintenance> maintenances = maintenanceRepository.findAll();
		 List<MaintenanceDTO> maintenanceDTOs = maintenances.stream().map(p -> new MaintenanceDTO(p)).toList();
		
		return maintenanceDTOs;
	}
	@Transactional(readOnly = true)
	public MaintenanceDTO getByIdMaintenance(Long id) {
		
		Maintenance maintenance = maintenanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not valid"));
		return new MaintenanceDTO(maintenance, maintenance.getPrinter());
	}
	@Transactional
	public MaintenanceDTO insertMaintenance(@Valid MaintenanceDTO maintenanceDTO) {
		
		Maintenance maintenance = new Maintenance();
		copyDtoToMaintenance(maintenanceDTO, maintenance);
		maintenanceRepository.save(maintenance);
		return new MaintenanceDTO(maintenance, maintenance.getPrinter());
	}
	@Transactional
	public MaintenanceDTO updateMaintenanceId(Long id, MaintenanceDTO maintenanceDTO) {
		
		try {
			Maintenance maintenance = maintenanceRepository.getReferenceById(id);
			maintenanceDTO.setUpdated_At(Instant.now());
			copyDtoToMaintenance(maintenanceDTO, maintenance);
			maintenance = maintenanceRepository.save(maintenance);
			return new MaintenanceDTO(maintenance, maintenance.getPrinter());
		
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
	public void deleteMaintenanceId(Long id) {
		try {
			if (!maintenanceRepository.existsById(id)) {
				throw new ResourceNotFoundException("Id not found " + id);
			}else {
				maintenanceRepository.deleteById(id);
			}
		}catch (DataIntegrityViolationException e) {
			throw new ResourceNotFoundException("Integrity Violation " +id );
		}
	}
	
	public void copyDtoToMaintenance(MaintenanceDTO dto, Maintenance maintenance) {
		maintenance.setEndWarranty(dto.getEndWarranty());
		maintenance.setMaitenanceShippingDate(dto.getMaitenanceShippingDate());
		maintenance.setText(dto.getText());
		maintenance.setPrice(dto.getPrice());
		maintenance.setUpdated_At(dto.getUpdated_At());
		
		Printer printer = printerRepository.findById(dto.getPrinter().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Id not valid"));
		maintenance.setPrinter(printer);
		
	}
}




