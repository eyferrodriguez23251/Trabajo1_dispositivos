package com.ejemplo.polimorfismo.modelo;

import java.util.Stack;

public class DispositivoTrabajo3 {
    private String nombre;
    private String marca;
    private String modelo;
    private TipoDispositivoEnum tipo;
    private Categoria categoria;
    private Stack<Integer> conteo;

    public DispositivoTrabajo3() {
        this.conteo = new Stack<>();
    }

    public DispositivoTrabajo3(String nombre, String marca, String modelo,
                               TipoDispositivoEnum tipo, Categoria categoria,
                               Stack<Integer> conteo) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.categoria = categoria;
        this.conteo = conteo == null ? new Stack<>() : conteo;
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setTipo(TipoDispositivoEnum tipo) { this.tipo = tipo; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public void setConteo(Stack<Integer> conteo) { this.conteo = conteo; }

    public String getNombre() { return nombre; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public TipoDispositivoEnum getTipo() { return tipo; }
    public Categoria getCategoria() { return categoria; }
    public Stack<Integer> getConteo() { return conteo; }

    public void agregarConteo(int valor) { conteo.push(valor); }

    public void verTotales(java.util.function.Function<DispositivoTrabajo3, Integer> funcion) {
        System.out.println("Total de conteo para " + nombre + ": " + funcion.apply(this));
    }

    @Override
    public String toString() {
        return "DispositivoTrabajo3{nombre='" + nombre + "', marca='" + marca +
                "', modelo='" + modelo + "', tipo=" + tipo + ", categoria=" +
                categoria + ", conteo=" + conteo + "}";
    }
}
