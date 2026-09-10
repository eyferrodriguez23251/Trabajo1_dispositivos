package com.ejemplo.polimorfismo.controlador;

import com.ejemplo.polimorfismo.interfaz.DispositivoInterface;
import com.ejemplo.polimorfismo.modelo.Bluetooth;
import com.ejemplo.polimorfismo.modelo.Cable;
import com.ejemplo.polimorfismo.modelo.Dispositivo;
import com.ejemplo.polimorfismo.modelo.Wifi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DispositivoController {

    @GetMapping("/")
    public String inicio(Model model) {

        List<DispositivoInterface> dispositivos = new ArrayList<>();

        dispositivos.add(new Wifi("Laptop", "Lenovo", "IdeaPad 3", "Activo"));
        dispositivos.add(new Wifi("Celular", "Samsung", "Galaxy A55", "Activo"));
        dispositivos.add(new Wifi("Tablet", "Xiaomi", "Redmi Pad", "Activo"));

        dispositivos.add(new Bluetooth("Audífonos", "Sony", "WH-CH520", "Activo"));
        dispositivos.add(new Bluetooth("Parlante", "JBL", "Flip 6", "Activo"));
        dispositivos.add(new Bluetooth("Mouse", "Logitech", "M350", "Activo"));

        dispositivos.add(new Cable("Computador", "Dell", "OptiPlex 7010", "Activo"));
        dispositivos.add(new Cable("Impresora", "HP", "LaserJet Pro", "Activo"));
        dispositivos.add(new Cable("Monitor", "LG", "24MP400", "Activo"));

        model.addAttribute("dispositivos", dispositivos);
        model.addAttribute("total", dispositivos.size());

        return "index";
    }
}
