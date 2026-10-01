package com.ejemplo.polimorfismo.modelo;

import com.ejemplo.polimorfismo.interfaz.DispositivoInterface;
import java.util.List;

public class Bluetooth implements DispositivoInterface {

    private final String nombre;
    private final List<Dispositivo> dispositivos;

    public Bluetooth(String nombre, List<Dispositivo> dispositivos) {
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
        return "Emparejamiento Bluetooth realizado con " + lista.size() + " dispositivos.";
    }

    @Override
    public String transmitir(List<Dispositivo> lista) {
        return "Transmitiendo datos vía Bluetooth a " + lista.size() + " dispositivos.";
    }

    @Override
    public String desconectar(List<Dispositivo> lista) {
        return "Dispositivos Bluetooth desemparejados: " + lista.size() + ".";
    }
}
