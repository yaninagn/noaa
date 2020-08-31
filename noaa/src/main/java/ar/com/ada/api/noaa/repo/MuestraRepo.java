package ar.com.ada.api.noaa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.com.ada.api.noaa.entities.Muestra;

public interface MuestraRepo extends JpaRepository<Muestra, Integer>{
    

    @Query("select h from muestra h order by boya_id")
    List<Muestra> findAllOrderById(Integer boyaId);
}