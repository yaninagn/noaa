package ar.com.ada.api.noaa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.repo.BoyaRepo;

@Service
public class BoyaService {

    @Autowired
    BoyaRepo boyaRepo;

    public void crearBoya(Boya boya) {
        boyaRepo.save(boya);
    }

    public Boya crearBoya(String nombre, double latBoya, double longBoya) {
        Boya boya = new Boya();
        boya.setColorBoya(null);
        boya.setLatBoya(latBoya);
        boya.setLongBoya(longBoya);
        boyaRepo.save(boya);
        return boya;
    }

    public Boya actualizarBoya(Boya boya) {
        return boyaRepo.save(boya);
    }

    public Boya buscarPorId(Integer boyaId) {
        Optional<Boya> opBoya = boyaRepo.findById(boyaId);

        // Si tiene un valor de boya en el elemento que trajo.
        // Camion con heladera dentro. hasta que no abrimos la puerta no sabemos si la
        // trajo.
        if (opBoya.isPresent())
            return opBoya.get();
        else
            return null;

    }

    public List<Boya> listarTodas() {
        return boyaRepo.findAll();
    }

}