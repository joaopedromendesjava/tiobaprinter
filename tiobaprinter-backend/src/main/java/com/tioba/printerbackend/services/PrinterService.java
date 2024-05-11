package com.tioba.printerbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tioba.printerbackend.dto.PrinterDTO;
import com.tioba.printerbackend.entities.Printer;
import com.tioba.printerbackend.repositories.PrinterRepository;


@Service
public class PrinterService {

	@Autowired
	private PrinterRepository printerRepository;
	
	@Transactional(readOnly = true)
	public List<PrinterDTO> allPrinters(){
		
		 List<Printer> printers = printerRepository.findAll();
		 List<PrinterDTO> printerDTOs = printers.stream().map(p -> new PrinterDTO(p)).toList();
		
		return printerDTOs;
	}
	
	public PrinterDTO getByIdPrinter(Long id) {
		
		Printer printer = printerRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
		return new PrinterDTO(printer);
	}
	
	@Transactional
	public PrinterDTO insertPrinter(PrinterDTO printerDTO) {
		
		Printer printer = new Printer();
		copyDtoToPrinter(printerDTO, printer);
		printerRepository.save(printer);
		return new PrinterDTO(printer);
	}
	
	public void copyDtoToPrinter(PrinterDTO dto, Printer printer) {
		printer.setModel(dto.getModel());
		printer.setPrice(dto.getPrice());
		printer.setUpdated_At(dto.getUpdated_At());
	}

	
}




