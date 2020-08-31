package ar.com.ada.api.noaa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.ada.api.noaa.entities.Muestra;
import ar.com.ada.api.noaa.models.response.MuestraResponse;
import ar.com.ada.api.noaa.services.MuestraService;

public class MuestraController {
    /*
POST /muestras   : que registre una muestra 
RequestBody { 
 “boyaId”: 32, 
 “horario”: “2020-08-08T22:25:30”,  //La separación de FECHA y HORA es por “T” 
 “matricula”: “99D9AAK” 
 “latitud”: -17.44681203, 
 “longitud”: -113.16478854, 
 “alturaNivelDelMar”: 50 
} 
Respuesta Esperada(JSON): 
{ 
 “id”: 25 //O cualquier número de muestra que devuelva. 
 “color”: “Un Color”  //Este será el color que deberá cambiar la luz de la boya 
} 
Nota: Si cuando se carga una muestra nueva en una boya, la alturaNivelDelMar es de MENOS de       -50(menos 50) o  de MAS de +50 (más 50), debera devolver “AMARILLO” en el color. 
En el caso de que sea menor a -100  o mayor a +100 el color deberá ser ROJO. 
Si no, el color deberá devolver es VERDE  
 */
@Autowired

MuestraService muestraService;

@PostMapping("/muestra")
public ResponseEntity<MuestraResponse> crearBoya(@RequestBody Muestra muestra) {
    muestraService.crearMuestra(muestra);

    if (muestra == null)
        return ResponseEntity.badRequest().build();

   MuestraResponse r = new MuestraResponse();
    r.id = muestra.getMuestraId();
    return ResponseEntity.ok(r);
//me falta hacer que tire el nuevo color

}


/*
GET /muestras/boyas/{idBoya} : que devuelva la lista de muestras de una boya, indicado por “idBoya”. 
 */
@GetMapping("/muestras/boyas/{boyaId}")
    ResponseEntity<List<Muestra>> listarMuestras(@PathVariable Integer boyaId) {
        List<Muestra> listaMuestras = muestraService.listarMuestrasPorId(boyaId);

        return ResponseEntity.ok(listaMuestras);
    }


 /*
DELETE /muestras/{id}:   Reseteara el color de la luz de la boya a “AZUL” a partir de una muestra especifica  
    */
}