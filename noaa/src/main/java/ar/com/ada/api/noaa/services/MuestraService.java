package ar.com.ada.api.noaa.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.entities.Muestra;
import ar.com.ada.api.noaa.repo.MuestraRepo;

@Service
public class MuestraService {

    @Autowired
    MuestraRepo muestraRepo;
    @Autowired
    BoyaService boyaService;

    public void crearMuestra(Muestra muestra) {

        /*
         * double alt = muestra.getAlturaNivelMar(); Boya boya = muestra.getBoya(); /*
         * Si cuando se carga una muestra nueva en una boya, la alturaNivelDelMar es de
         * MENOS de -50 (menos 50) o de MAS de +50 (más 50), debera devolver “AMARILLO”
         * en el color. En el caso de que sea menor a -100 o mayor a +100 el color
         * deberá ser ROJO. Si no, el color deberá devolver es VERDE
         * 
         * if (alt > -50 && alt < 50) { boya.setColorBoya("VERDE"); } else if (alt >
         * -100 && alt > 100) { boya.setColorBoya("AMARILLO"); } else {
         * boya.setColorBoya("ROJO"); }
         * 
         * boyaService.actualizarBoya(muestra.getBoya());
         */
        muestraRepo.save(muestra);
    }

    public Muestra crearNuevaMuestra (int boyaId, Date horarioMuestra,String matEmbarcacion, double longitud, double latitud, Integer alturaNivelMar) {

    
            Muestra mc = new Muestra();
            mc.setBoya(mc.getBoya());
            mc.setAlturaNivelMar(mc.getAlturaNivelMar());
            mc.setHorarioMuestra(mc.getHorarioMuestra());
            mc.setLatitud(mc.getLatitud());
            mc.setLongitud(mc.getLongitud());
            mc.setMatEmbarcacion(mc.getMatEmbarcacion());
          
            crearMuestra(mc);
            return mc;
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