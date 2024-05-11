package com.tioba.printerbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tioba.printerbackend.entities.Printer;

@Repository
public interface PrinterRepository extends JpaRepository<Printer, Long>{

}
