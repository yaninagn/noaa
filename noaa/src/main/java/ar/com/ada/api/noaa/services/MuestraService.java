package ar.com.ada.api.noaa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entities.Muestra;
import ar.com.ada.api.noaa.repo.MuestraRepo;


@Service
public class MuestraService {

    @Autowired
    MuestraRepo muestraRepo;

    public void crearMuestra(Muestra muestra) {
        muestraRepo.save(muestra);
    }

    public Muestra actualizarMuestra(Muestra muestra) {
        return muestraRepo.save(muestra);
    }

    public Muestra buscarPorId(Integer muestraId) {
        Optional<Muestra> opMuestra = muestraRepo.findById(muestraId);

        // Si tiene un valor de muestra en el elemento que trajo.
        // Camion con heladera dentro. hasta que no abrimos la puerta no sabemos si la
        // trajo.
        if (opMuestra.isPresent())
            return opMuestra.get();
        else
            return null;

    }

    public List<Muestra> listarTodas() {
        return muestraRepo.findAll();
    }

}