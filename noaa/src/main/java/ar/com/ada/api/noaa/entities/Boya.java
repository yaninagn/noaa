package ar.com.ada.api.noaa.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "boya")
public class Boya {

    @Id
    @Column(name = "boya_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boyaId;
    private String colorBoya ;   

    
    @OneToMany(mappedBy = "muestra", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Muestra> muestras = new ArrayList<>();
    private double longBoya;

    private double latBoya;

    public Integer getBoyaId() {
        return boyaId;
    }

    public void setBoyaId(Integer boyaId) {
        this.boyaId = boyaId;
    }

    public List<Muestra> getMuestras() {
        return muestras;
    }

    public void setMuestras(List<Muestra> muestras) {
        this.muestras = muestras;
    }

    public double getLongBoya() {
        return longBoya;
    }

    public void setLongBoya(double longBoya) {
        this.longBoya = longBoya;
    }

    public double getLatBoya() {
        return latBoya;
    }

    public void setLatBoya(double latBoya) {
        this.latBoya = latBoya;
    }

    public String getColorBoya() {
        return colorBoya;
    }

    public void setColorBoya(String colorBoya) {
        this.colorBoya = colorBoya;
    }


}