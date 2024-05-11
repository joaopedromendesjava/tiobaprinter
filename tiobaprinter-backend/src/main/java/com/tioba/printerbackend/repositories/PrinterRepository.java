package com.tioba.printerbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tioba.printerbackend.entities.Printer;

public interface PrinterRepository extends JpaRepository<Printer, Long>{

}
