package com.bcp.tipo_cambio.model;

public class TipoCambioOuput {

    private double montoOriginal;
    private double montoTipoCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private double tipoCambio;

    public double getMontoOriginal() {
        return montoOriginal;
    }

    public void setMontoOriginal(double montoOriginal) {
        this.montoOriginal = montoOriginal;
    }

    public double getMontoTipoCambio() {
        return montoTipoCambio;
    }

    public void setMontoTipoCambio(double montoTipoCambio) {
        this.montoTipoCambio = montoTipoCambio;
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
