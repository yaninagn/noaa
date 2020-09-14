package ar.com.ada.api.noaa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.models.request.BoyaCreate;
import ar.com.ada.api.noaa.models.request.BoyaModifRequest;
import ar.com.ada.api.noaa.models.response.*;
import ar.com.ada.api.noaa.services.BoyaService;

@RestController
public class BoyaController {

    @Autowired
    BoyaService boyaService;

    @PostMapping("/boyas")
    public ResponseEntity<GenericResponse> crearBoya(@RequestBody BoyaCreate boyaCreate) {
        Boya boyaCreada = boyaService.crearBoya(boyaCreate.latitudInstalacion, boyaCreate.longitudInstalacion);


        if (boyaCreada == null)
            return ResponseEntity.badRequest().build();

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.message = "Boya Creada con exito";
        r.id = boyaCreada.getBoyaId();
        return ResponseEntity.ok(r);

    }

    // solo se modifica el color de la boya
    @PutMapping(("/boyas/{id}"))
    ResponseEntity<GenericResponse> actualizarBoyaPorId(@PathVariable Integer id, @RequestBody BoyaModifRequest bMR) {
        Boya boya = boyaService.buscarPorId(id);
        if (boya == null) {
            return ResponseEntity.notFound().build();
        }

        boya.setColorBoya(bMR.colorBoya);
        Boya boyaActualizada = boyaService.actualizarBoya(boya);

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.message = "Boya actualizada con éxito";
        r.id = boyaActualizada.getBoyaId();

        return ResponseEntity.ok(r);
    }

    // me trae la boya seleccionada sin muestras
    @GetMapping("/boyas/{id}")
    ResponseEntity<Boya> buscarPorIdBoya(@PathVariable Integer id) {
        Boya boya = boyaService.buscarPorId(id);
        if (boya == null) {
            return ResponseEntity.notFound().build();
        }

        else {
            return ResponseEntity.ok(boya);
        }
    }

    // lista todas las boyas sin muestras
    @GetMapping("/boyas")
    ResponseEntity<List<Boya>> listarBoyas() {
        List<Boya> listaBoyas = boyaService.listarTodas();

        return ResponseEntity.ok(listaBoyas);
    }

}
