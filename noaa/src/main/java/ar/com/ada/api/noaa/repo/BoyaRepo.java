package ar.com.ada.api.noaa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.noaa.entities.Boya;


public interface BoyaRepo extends JpaRepository<Boya, Integer>{

public List<Boya> findByColorBoya(String colorBoya);
}