package com.bcp.tipo_cambio.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TBL_TIPO_CAMBIO")
public class EntityTipoCambio implements Serializable {

    // Para guardar I/O en disco
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="MONEDA_ORIGEN")
    private String monedaOrigen;

    @Column(name="MONEDA_DESTINO")
    private String monedaDestino;

    @Column(name="TIPO_CAMBIO", scale = 2, precision = 2)
    private double tipoCambio;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
}
