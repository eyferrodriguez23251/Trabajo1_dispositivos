package com.ejemplo.polimorfismo.modelo;

import java.util.ArrayDeque;
import java.util.Deque;

public class RedDispositivos {
    private String nombre;
    private String ubicacion;
    private TipoDispositivoEnum tipo;
    private Categoria categoria;
    private Deque<DispositivoTrabajo3> dispositivos;

    public RedDispositivos() {
        this.dispositivos = new ArrayDeque<>();
    }

    public RedDispositivos(String nombre, String ubicacion, TipoDispositivoEnum tipo,
                           Categoria categoria, Deque<DispositivoTrabajo3> dispositivos) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.categoria = categoria;
        this.dispositivos = dispositivos == null ? new ArrayDeque<>() : dispositivos;
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public void setTipo(TipoDispositivoEnum tipo) { this.tipo = tipo; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public void setDispositivos(Deque<DispositivoTrabajo3> dispositivos) { this.dispositivos = dispositivos; }

    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }
    public TipoDispositivoEnum getTipo() { return tipo; }
    public Categoria getCategoria() { return categoria; }
    public Deque<DispositivoTrabajo3> getDispositivos() { return dispositivos; }

    public void agregarDispositivo(DispositivoTrabajo3 dispositivo) {
        dispositivos.addLast(dispositivo);
    }
}
