package ar.com.ada.api.noaa.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "muestra")
public class Muestra {
    @Id
    @Column(name = "muestra_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer muestraId;
 
    @ManyToOne
    @JoinColumn(name = "boya_id", referencedColumnName = "boya_id")
    private Boya boya;
    @Column(name = "horario_muestra")
    private Date horarioMuestra;
    @Column(name = "mat_embarcacion")
    private String matEmbarcacion;
    @Column(name = "longitud_muestra")
    private double longMuestra;
    @Column(name = "latitud_muestra")
    private double latMuestra;
    @Column(name = "altura_nivel")
    private Integer alturaNivelMar;

    public Integer getMuestraId() {
        return muestraId;
    }

    public void setMuestraId(Integer muestraId) {
        this.muestraId = muestraId;
    }

    public Boya getBoya() {
        return boya;
    }

    public void setBoya(Boya boya) {
        this.boya = boya;
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

    public double getLongMuestra() {
        return longMuestra;
    }

    public void setLongMuestra(double longMuestra) {
        this.longMuestra = longMuestra;
    }

    public double getLatMuestra() {
        return latMuestra;
    }

    public void setLatMuestra(double latMuestra) {
        this.latMuestra = latMuestra;
    }

    public Integer getAlturaNivelMar() {
        return alturaNivelMar;
    }

    public void setAlturaNivelMar(Integer alturaNivelMar) {
        this.alturaNivelMar = alturaNivelMar;
    }

}
    
