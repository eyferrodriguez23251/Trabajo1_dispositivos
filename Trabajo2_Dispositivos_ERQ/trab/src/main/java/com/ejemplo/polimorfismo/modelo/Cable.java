package com.ejemplo.polimorfismo.modelo;

import com.ejemplo.polimorfismo.interfaz.DispositivoInterface;
import java.util.List;

public class Cable implements DispositivoInterface {

    private final String nombre;
    private final List<Dispositivo> dispositivos;

    public Cable(String nombre, List<Dispositivo> dispositivos) {
        this.nombre = nombre;
        this.dispositivos = dispositivos;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    @Override
    public String conectar(List<Dispositivo> lista) {
        return "Conexión Ethernet por Cable establecida para " + lista.size() + " dispositivos.";
    }

    @Override
    public String transmitir(List<Dispositivo> lista) {
        return "Transmisión cableada de alta velocidad hacia " + lista.size() + " dispositivos.";
    }

    @Override
    public String desconectar(List<Dispositivo> lista) {
        return "Cable desconectado de " + lista.size() + " dispositivos.";
    }
}
