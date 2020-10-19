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

    public Boya crearBoya(double latitudIstalacion, double longitudInstalacion) {
        Boya boya = new Boya();
        boya.setColorBoya(null);
        boya.setLatitudInstalacion(latitudIstalacion);
        boya.setLongitudInstalacion(longitudInstalacion);
        boyaRepo.save(boya);
        return boya;
    }

    public Boya actualizarBoya(Boya boya) {
        return boyaRepo.save(boya);
    }

    public Boya actualizarColorBoyaPorId(Integer boyaId, Integer alturaNivelMar) {

        Boya boya = buscarPorId(boyaId);

        if (alturaNivelMar < -50 || alturaNivelMar > 50) { 
            boya.setColorBoya("AMARILLO"); 
        } else if (alturaNivelMar <  -100 || alturaNivelMar > 100) {
            boya.setColorBoya("ROJO"); 
        } else {
            boya.setColorBoya("VERDE"); 
        }
        
        actualizarBoya(boya);

        return boya;
    }

    public Boya buscarPorId(Integer boyaId) {
        Optional<Boya> opBoya = boyaRepo.findById(boyaId);

        if (opBoya.isPresent())
            return opBoya.get();
        else
            return null;

    }

    public List<Boya> listarTodas() {
        return boyaRepo.findAll();
    }

	public List<Boya> listarTodas(String color) {
		return boyaRepo.findByColorBoya(color);
	}

}