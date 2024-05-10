package com.tioba.printerbackend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tioba.printerbackend.entities.Printer;

public interface PrinterRepository extends CrudRepository<Printer, Long>{

}
