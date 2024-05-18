package com.tioba.printerbackend.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tioba.printerbackend.dto.MaintenanceOrderDTO;
import com.tioba.printerbackend.entities.MaintenanceOrder;
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
	public List<MaintenanceOrderDTO> allMaintenances(){
		
		 List<MaintenanceOrder> maintenances = maintenanceRepository.findAll();
		 List<MaintenanceOrderDTO> maintenanceOrderDTOs = maintenances.stream().map(p -> new MaintenanceOrderDTO(p, p.getPrinter())).toList();
		
		return maintenanceOrderDTOs;
	}
	@Transactional(readOnly = true)
	public MaintenanceOrderDTO getByIdMaintenance(Long id) {
		
		MaintenanceOrder maintenanceOrder = maintenanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not valid"));
		return new MaintenanceOrderDTO(maintenanceOrder, maintenanceOrder.getPrinter());
	}
	@Transactional
	public MaintenanceOrderDTO insertMaintenance(@Valid MaintenanceOrderDTO maintenanceOrderDTO) {
		
		MaintenanceOrder maintenanceOrder = new MaintenanceOrder();
		copyDtoToMaintenance(maintenanceOrderDTO, maintenanceOrder);
		maintenanceRepository.save(maintenanceOrder);
		return new MaintenanceOrderDTO(maintenanceOrder, maintenanceOrder.getPrinter());
	}
	@Transactional
	public MaintenanceOrderDTO updateMaintenanceId(Long id, MaintenanceOrderDTO maintenanceOrderDTO) {
		
		try {
			MaintenanceOrder maintenanceOrder = maintenanceRepository.getReferenceById(id);
			maintenanceOrder.setUpdated_At(Instant.now());
			copyDtoToMaintenance(maintenanceOrderDTO, maintenanceOrder);
			maintenanceOrder = maintenanceRepository.save(maintenanceOrder);
			return new MaintenanceOrderDTO(maintenanceOrder, maintenanceOrder.getPrinter());
		
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
	
	public void copyDtoToMaintenance(MaintenanceOrderDTO dto, MaintenanceOrder maintenanceOrder) {
		maintenanceOrder.setCloseDate(dto.getCloseDate());
		maintenanceOrder.setDescription(dto.getDescription());
		maintenanceOrder.setOpeningDate(dto.getOpeningDate());
		maintenanceOrder.setStatus(dto.getStatus());
		
		Printer printer = printerRepository.findById(dto.getPrinter().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Id not valid"));
		maintenanceOrder.setPrinter(printer);
		
	}
}




