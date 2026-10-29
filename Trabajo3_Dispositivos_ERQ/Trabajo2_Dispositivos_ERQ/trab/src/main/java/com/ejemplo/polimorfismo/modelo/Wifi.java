package com.ejemplo.polimorfismo.modelo;

import com.ejemplo.polimorfismo.interfaz.DispositivoInterface;
import java.util.List;

public class Wifi implements DispositivoInterface {

    private final String nombre;
    private final List<Dispositivo> dispositivos;

    public Wifi(String nombre, List<Dispositivo> dispositivos) {
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
        return "Conexión WiFi activada para " + lista.size() + " dispositivos.";
    }

    @Override
    public String transmitir(List<Dispositivo> lista) {
        return "Transmitiendo datos por red WiFi hacia " + lista.size() + " dispositivos.";
    }

    @Override
    public String desconectar(List<Dispositivo> lista) {
        return "Desconexión WiFi realizada para " + lista.size() + " dispositivos.";
    }
}
