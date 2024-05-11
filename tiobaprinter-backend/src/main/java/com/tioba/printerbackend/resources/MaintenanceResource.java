package com.tioba.printerbackend.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tioba.printerbackend.dto.MaintenanceDTO;
import com.tioba.printerbackend.services.MaintenanceService;

@RestController
@RequestMapping(value = "/maintenances")
public class MaintenanceResource {

	@Autowired
	private MaintenanceService maintenanceService;
	
	@GetMapping
	public ResponseEntity<List<MaintenanceDTO>> allMaintenances(){
		
		List<MaintenanceDTO> maintenanceDTOs = maintenanceService.allMaintenances();
		
		return ResponseEntity.ok().body(maintenanceDTOs);
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<MaintenanceDTO> getByIdMaintenance(@PathVariable(value = "id") Long id){
		
		MaintenanceDTO maintenanceDTO = maintenanceService.getByIdMaintenance(id);
		
		return ResponseEntity.ok().body(maintenanceDTO);
	}
	
	@PostMapping
	public ResponseEntity<MaintenanceDTO> saveMaintenance(@RequestBody MaintenanceDTO maintenanceDTO){
		
		maintenanceDTO = maintenanceService.insertMaintenance(maintenanceDTO); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(maintenanceDTO.getId()).toUri();
		
		return ResponseEntity.created(uri).body(maintenanceDTO);
		
	}
	@PutMapping(path = "/{id}")
	public ResponseEntity<MaintenanceDTO> updateMaintenanceId(@PathVariable(value = "id") Long id, @RequestBody MaintenanceDTO maintenanceDTO){
		
		maintenanceDTO = maintenanceService.updateMaintenanceId(id, maintenanceDTO);
		return ResponseEntity.ok().body(maintenanceDTO);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteMaintenance(@PathVariable(value = "id") Long id){
		
		maintenanceService.deleteMaintenanceId(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
