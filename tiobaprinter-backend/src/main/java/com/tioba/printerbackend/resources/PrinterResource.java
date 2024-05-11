package com.tioba.printerbackend.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tioba.printerbackend.dto.PrinterDTO;
import com.tioba.printerbackend.services.PrinterService;

@RestController
@RequestMapping(value = "/printers")
public class PrinterResource {

	@Autowired
	private PrinterService printerService;
	
	@GetMapping
	public ResponseEntity<List<PrinterDTO>> allPrinters(){
		
		List<PrinterDTO> printerDTOs = printerService.allPrinters();
		
		return ResponseEntity.ok().body(printerDTOs);
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<PrinterDTO> getByIdPrinter(@PathVariable(value = "id") Long id){
		
		PrinterDTO printerDTO = printerService.getByIdPrinter(id);
		
		return ResponseEntity.ok().body(printerDTO);
	}
	
	@PostMapping
	public ResponseEntity<PrinterDTO> savePrinter(@RequestBody PrinterDTO printerDTO){
		
		printerDTO = printerService.insertPrinter(printerDTO); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(printerDTO.getId()).toUri();
		
		return ResponseEntity.created(uri).body(printerDTO);
		
	}
}
