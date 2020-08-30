package ar.com.ada.api.noaa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.noaa.entities.Muestra;

public interface MuestraRepo extends JpaRepository<Muestra, Integer>{
    
}