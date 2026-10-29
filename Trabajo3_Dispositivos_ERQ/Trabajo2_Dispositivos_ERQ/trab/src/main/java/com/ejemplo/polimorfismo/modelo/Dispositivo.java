package com.ejemplo.polimorfismo.modelo;

public class Dispositivo {

    private final String nombre;
    private final String marca;
    private final String modelo;
    private final String tipoConexion;
    private final String estado;
    private final Integer consumoVatios; // Atributo numérico Integer para programación funcional

    public Dispositivo(String nombre, String marca, String modelo, String tipoConexion, String estado, Integer consumoVatios) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoConexion = tipoConexion;
        this.estado = estado;
        this.consumoVatios = consumoVatios;
    }

    public String getNombre() { return nombre; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getTipoConexion() { return tipoConexion; }
    public String getEstado() { return estado; }
    public Integer getConsumoVatios() { return consumoVatios; }

    @Override
    public String toString() {
        return nombre + " (" + marca + " " + modelo + ", Consumo: " + consumoVatios + "W, Estado: " + estado + ")";
    }
}
