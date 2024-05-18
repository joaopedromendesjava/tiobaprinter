package com.tioba.printerbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tioba.printerbackend.entities.MaintenanceOrder;
@Repository
public interface MaintenanceRepository extends JpaRepository<MaintenanceOrder, Long>{

}
