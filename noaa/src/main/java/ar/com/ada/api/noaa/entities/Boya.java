package ar.com.ada.api.noaa.entities;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "boya")
public class Boya {

    @Id
    @Column(name = "boya_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boyaId;
    @Column(name = "color_boya")
    private String colorBoya ;   

  
    @OneToMany(mappedBy = "boya", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    @JsonIgnore
    private List<Muestra> muestras = new ArrayList<>();
    @Column(name = "longitud_boya")
    private double longitudInstalacion;
    @Column(name = "latitud_boya")
    private double latitudInstalacion;

    

    public Integer getBoyaId() {
        return boyaId;
    }

    public void setBoyaId(final Integer boyaId) {
        this.boyaId = boyaId;
    }

    public List<Muestra> getMuestras() {
        return muestras;
    }

    public void setMuestras(final List<Muestra> muestras) {
        this.muestras = muestras;
    }

    public double getLongitudInstalacion() {
        return longitudInstalacion;
    }

    public void setLongitudInstalacion(final double longitudInstalacion) {
        this.longitudInstalacion = longitudInstalacion;
    }

    public double getLatitudInstalacion() {
        return latitudInstalacion;
    }

    public void setLatitudInstalacion(final double latitudInstalacion) {
        this.latitudInstalacion = latitudInstalacion;
    }

    public String getColorBoya() {
        return colorBoya;
    }

    public void setColorBoya(final String colorBoya) {
        this.colorBoya = colorBoya;
    }

    public Boya() {
    }

    public Boya(Integer boyaId) {
        this.boyaId = boyaId;
    }
  
}