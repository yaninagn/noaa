package ar.com.ada.api.noaa.models.request;

import java.util.Date;

public class MuestraCreate {

    private Integer boyaId;
    private Date horarioMuestra;
    private String matEmbarcacion;
    private double longitud;
    private double latitud;
    private Integer alturaNivelMar;

    public Integer getBoyaId() {
        return boyaId;
    }

    public void setBoya(Integer boyaId) {
        this.boyaId = boyaId;
    }

    public Date getHorarioMuestra() {
        return horarioMuestra;
    }

    public void setHorarioMuestra(Date horarioMuestra) {
        this.horarioMuestra = horarioMuestra;
    }

    public String getMatEmbarcacion() {
        return matEmbarcacion;
    }

    public void setMatEmbarcacion(String matEmbarcacion) {
        this.matEmbarcacion = matEmbarcacion;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public Integer getAlturaNivelMar() {
        return alturaNivelMar;
    }

    public void setAlturaNivelMar(Integer alturaNivelMar) {
        this.alturaNivelMar = alturaNivelMar;
    }

    
    
}
