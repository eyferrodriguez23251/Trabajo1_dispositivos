package com.ejemplo.polimorfismo.modelo;

import com.ejemplo.polimorfismo.interfaz.DispositivoInterface;

public class Cable extends Dispositivo implements DispositivoInterface {

    public Cable(String nombre, String marca, String modelo, String estado) {
        super(nombre, marca, modelo, "Cable", estado);
    }

    @Override
    public String conectar(Dispositivo dispositivo) {
        return dispositivo.getNombre() + " se conectó mediante Cable.";
    }

    @Override
    public String transmitir(Dispositivo dispositivo) {
        return dispositivo.getNombre() + " está transmitiendo datos por cable.";
    }

    @Override
    public String desconectar(Dispositivo dispositivo) {
        return dispositivo.getNombre() + " terminó su conexión por cable.";
    }
}
