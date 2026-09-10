package com.ejemplo.polimorfismo.modelo;

import com.ejemplo.polimorfismo.interfaz.DispositivoInterface;

public class Wifi extends Dispositivo implements DispositivoInterface {

    public Wifi(String nombre, String marca, String modelo, String estado) {
        super(nombre, marca, modelo, "WiFi", estado);
    }

    @Override
    public String conectar(Dispositivo dispositivo) {
        return dispositivo.getNombre() + " se conectó mediante WiFi.";
    }

    @Override
    public String transmitir(Dispositivo dispositivo) {
        return dispositivo.getNombre() + " está transmitiendo datos por WiFi.";
    }

    @Override
    public String desconectar(Dispositivo dispositivo) {
        return dispositivo.getNombre() + " terminó su conexión WiFi.";
    }
}
