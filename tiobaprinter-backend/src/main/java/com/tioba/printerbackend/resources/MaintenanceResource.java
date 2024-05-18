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

import com.tioba.printerbackend.dto.MaintenanceOrderDTO;
import com.tioba.printerbackend.services.MaintenanceService;

@RestController
@RequestMapping(value = "/maintenances")
public class MaintenanceResource {

	@Autowired
	private MaintenanceService maintenanceService;
	
	@GetMapping
	public ResponseEntity<List<MaintenanceOrderDTO>> allMaintenances(){
		
		List<MaintenanceOrderDTO> maintenanceOrderDTOs = maintenanceService.allMaintenances();
		
		return ResponseEntity.ok().body(maintenanceOrderDTOs);
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<MaintenanceOrderDTO> getByIdMaintenance(@PathVariable(value = "id") Long id){
		
		MaintenanceOrderDTO maintenanceOrderDTO = maintenanceService.getByIdMaintenance(id);
		
		return ResponseEntity.ok().body(maintenanceOrderDTO);
	}
	
	@PostMapping
	public ResponseEntity<MaintenanceOrderDTO> saveMaintenance(@RequestBody MaintenanceOrderDTO maintenanceOrderDTO){
		
		maintenanceOrderDTO = maintenanceService.insertMaintenance(maintenanceOrderDTO); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(maintenanceOrderDTO.getId()).toUri();
		
		return ResponseEntity.created(uri).body(maintenanceOrderDTO);
		
	}
	@PutMapping(path = "/{id}")
	public ResponseEntity<MaintenanceOrderDTO> updateMaintenanceId(@PathVariable(value = "id") Long id, @RequestBody MaintenanceOrderDTO maintenanceOrderDTO){
		
		maintenanceOrderDTO = maintenanceService.updateMaintenanceId(id, maintenanceOrderDTO);
		return ResponseEntity.ok().body(maintenanceOrderDTO);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteMaintenance(@PathVariable(value = "id") Long id){
		
		maintenanceService.deleteMaintenanceId(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
