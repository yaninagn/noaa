package ar.com.ada.api.noaa.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.noaa.entities.*;
import ar.com.ada.api.noaa.models.request.MuestraCreate;
import ar.com.ada.api.noaa.models.response.MuestraResponse;
import ar.com.ada.api.noaa.services.BoyaService;
import ar.com.ada.api.noaa.services.MuestraService;

@RestController
public class MuestraController {
    /*
     * POST /muestras : que registre una muestra RequestBody { “boyaId”: 32,
     * “horario”: “2020-08-08T22:25:30”, //La separación de FECHA y HORA es por “T”
     * “matricula”: “99D9AAK” “latitud”: -17.44681203, “longitud”: -113.16478854,
     * “alturaNivelDelMar”: 50 } Respuesta Esperada(JSON): { “id”: 25 //O cualquier
     * número de muestra que devuelva. “color”: “Un Color” //Este será el color que
     * deberá cambiar la luz de la boya } Nota: Si cuando se carga una muestra nueva
     * en una boya, la alturaNivelDelMar es de MENOS de -50(menos 50) o de MAS de
     * +50 (más 50), debera devolver “AMARILLO” en el color. En el caso de que sea
     * menor a -100 o mayor a +100 el color deberá ser ROJO. Si no, el color deberá
     * devolver es VERDE
     */
    @Autowired
    MuestraService muestraService;
    @Autowired
    BoyaService boyaService;

    @PostMapping("/muestras")
    public ResponseEntity<MuestraResponse> registrarMuestra(@RequestBody MuestraCreate mc) {
        Muestra muestra = new Muestra();
        muestra.setBoya(new Boya(mc.getBoyaId()));
        muestra.setAlturaNivelMar(mc.getAlturaNivelMar());
        muestra.setHorarioMuestra(mc.getHorarioMuestra());
        muestra.setLatitud(mc.getLatitud());
        muestra.setLongitud(mc.getLongitud());
        muestra.setMatEmbarcacion(mc.getMatEmbarcacion());
        muestraService.crearMuestra(muestra);

        if (muestra == null)
            return ResponseEntity.badRequest().build();

        Boya boya = boyaService.actualizarColorBoyaPorId(muestra.getBoya().getBoyaId(), muestra.getAlturaNivelMar());

        MuestraResponse r = new MuestraResponse();
        r.id = muestra.getMuestraId();
        r.boyaColor = boya.getColorBoya();
        return ResponseEntity.ok(r);

    }

    // GET /muestras/boyas/{idBoya} : que devuelva la lista de muestras de una boya,
    // indicado por “idBoya”.
    @GetMapping("/muestras/boyas/{boyaId}")
    ResponseEntity<List<Muestra>> listarMuestrasPorBoyaId(@PathVariable Integer boyaId) {
        List<Muestra> listaMuestras = boyaService.buscarPorId(boyaId).getMuestras();

        return ResponseEntity.ok(listaMuestras);
    }

    /* GET /muestras/colores/{color} : que devuelva la lista de muestras de un color
    @GetMapping("/muestras/colores/{color}")
    public ResponseEntity<List<MuestraColorResponse>> listaMuestrasPorColor(@PathVariable String color) {
        List<Muestra> listaMuestrasPorColor = mService.obtenerPorColor(color);
        if (listaMuestrasPorColor.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ResponseMethodsMapper
        .crearListaMuestraColorResponse(listaMuestrasPorColor));
*/
        
    /*FALTA CREAR:
     * DELETE /muestras/{id}: Reseteara el color de la luz de la boya a “AZUL” a
     * partir de una muestra especifica
     

    }*/
}