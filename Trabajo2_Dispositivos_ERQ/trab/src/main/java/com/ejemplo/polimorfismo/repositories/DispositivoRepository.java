package com.ejemplo.polimorfismo.repositories;

import com.ejemplo.polimorfismo.interfaz.DispositivoInterface;
import com.ejemplo.polimorfismo.modelo.Bluetooth;
import com.ejemplo.polimorfismo.modelo.Cable;
import com.ejemplo.polimorfismo.modelo.Dispositivo;
import com.ejemplo.polimorfismo.modelo.Wifi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DispositivoRepository {

    public List<DispositivoInterface> get12Objetos() {
        List<DispositivoInterface> lista = new ArrayList<>();

        // Objetos con 0 a 5 elementos en su lista de Dispositivo
        List<Dispositivo> list0 = new ArrayList<>();
        
        List<Dispositivo> list1 = new ArrayList<>();
        list1.add(new Dispositivo("Smart TV 55", "LG", "OLED55", "WiFi", "Activo", 120));

        List<Dispositivo> list2 = new ArrayList<>();
        list2.add(new Dispositivo("Laptop Pro", "Apple", "MacBook Pro M2", "WiFi", "Activo", 65));
        list2.add(new Dispositivo("Smartphone", "Samsung", "Galaxy S23", "WiFi", "Inactivo", 15));

        List<Dispositivo> list3 = new ArrayList<>();
        list3.add(new Dispositivo("Audífonos Inalámbricos", "Sony", "WH-1000XM5", "Bluetooth", "Activo", 10));
        list3.add(new Dispositivo("Parlante Portátil", "JBL", "Charge 5", "Bluetooth", "Activo", 30));
        list3.add(new Dispositivo("Mouse Gamer", "Logitech", "G Pro X", "Bluetooth", "Inactivo", 5));

        List<Dispositivo> list4 = new ArrayList<>();
        list4.add(new Dispositivo("Servidor Principal", "Dell", "PowerEdge R750", "Cable", "Activo", 500));
        list4.add(new Dispositivo("Impresora Láser", "HP", "Color LaserJet", "Cable", "Activo", 250));
        list4.add(new Dispositivo("PC Escritorio", "Lenovo", "ThinkCentre M90", "Cable", "Activo", 180));
        list4.add(new Dispositivo("Switch de Red", "Cisco", "Catalyst 2960", "Cable", "Activo", 80));

        List<Dispositivo> list5 = new ArrayList<>();
        list5.add(new Dispositivo("Tablet Dibajo", "Wacom", "Cintiq Pro", "WiFi", "Activo", 45));
        list5.add(new Dispositivo("Consola Videojuegos", "Sony", "PlayStation 5", "WiFi", "Activo", 200));
        list5.add(new Dispositivo("Cámara IP Security", "TP-Link", "Tapo C200", "WiFi", "Activo", 12));
        list5.add(new Dispositivo("Proyector 4K", "Epson", "Home Cinema", "WiFi", "Inactivo", 150));
        list5.add(new Dispositivo("Asistente Virtual", "Amazon", "Echo Dot 5", "WiFi", "Activo", 15));

        // Creación de los 12 objetos combinando las clases concretas (Wifi, Cable, Bluetooth)
        lista.add(new Wifi("Nodo WiFi Central", list0));
        lista.add(new Wifi("Red Hogar Principal", list1));
        lista.add(new Wifi("Red Oficina 5G", list2));
        lista.add(new Wifi("Zona WiFi Visitantes", list3));

        lista.add(new Cable("Conexión Rack Servidores", list4));
        lista.add(new Cable("Enlace Cableado Lab 1", list5));
        lista.add(new Cable("Red Ethernet Dirección", list2));
        lista.add(new Cable("Conexión Punto de Venta", list1));

        lista.add(new Bluetooth("Módulo Bluetooth Central", list3));
        lista.add(new Bluetooth("Enlace Bluetooth Periféricos", list4));
        lista.add(new Bluetooth("Audio Bluetooth Sala", list2));
        lista.add(new Bluetooth("Red Sensor Bluetooth", list0));

        return lista;
    }
}
