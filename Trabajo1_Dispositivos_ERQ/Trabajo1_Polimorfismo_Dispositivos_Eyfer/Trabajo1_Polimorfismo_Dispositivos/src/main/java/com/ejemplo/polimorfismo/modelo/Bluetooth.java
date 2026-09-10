package com.ejemplo.polimorfismo.modelo;

import com.ejemplo.polimorfismo.interfaz.DispositivoInterface;

public class Bluetooth extends Dispositivo implements DispositivoInterface {

    public Bluetooth(String nombre, String marca, String modelo, String estado) {
        super(nombre, marca, modelo, "Bluetooth", estado);
    }

    @Override
    public String conectar(Dispositivo dispositivo) {
        return dispositivo.getNombre() + " se conectó mediante Bluetooth.";
    }

    @Override
    public String transmitir(Dispositivo dispositivo) {
        return dispositivo.getNombre() + " está transmitiendo datos por Bluetooth.";
    }

    @Override
    public String desconectar(Dispositivo dispositivo) {
        return dispositivo.getNombre() + " terminó su conexión Bluetooth.";
    }
}
