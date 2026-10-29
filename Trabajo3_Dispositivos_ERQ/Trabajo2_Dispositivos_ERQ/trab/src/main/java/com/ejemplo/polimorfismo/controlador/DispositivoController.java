package com.ejemplo.polimorfismo.controlador;

import com.ejemplo.polimorfismo.interfaz.DispositivoInterface;
import com.ejemplo.polimorfismo.modelo.Dispositivo;
import com.ejemplo.polimorfismo.repositories.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
public class DispositivoController {

    @Autowired
    private DispositivoRepository repository;

    @GetMapping("/")
    public String inicio(Model model) {
        List<DispositivoInterface> objetos = repository.get12Objetos();
        model.addAttribute("objetos", objetos);
        return "index";
    }

    // Punto 1 / Petición 1: Nombres de todas las clases concretas en una sola línea separados por coma
    @GetMapping("/peticion1")
    public String peticion1(Model model) {
        List<DispositivoInterface> objetos = repository.get12Objetos();

        String nombresSeparados = objetos.stream()
                .map(DispositivoInterface::getNombre)
                .collect(Collectors.joining(", "));

        model.addAttribute("titulo", "Petición 1: Nombres de los Objetos en una Sola Línea");
        model.addAttribute("resultado", nombresSeparados);
        return "peticion1";
    }

    // Punto 2 / Petición 2: Datos estadísticos (conteo, suma, promedio, min, max) de las listas contenidas
    @GetMapping("/peticion2")
    public String peticion2(Model model) {
        List<DispositivoInterface> objetos = repository.get12Objetos();

        IntSummaryStatistics estadisticas = objetos.stream()
                .mapToInt(o -> o.getDispositivos().size())
                .summaryStatistics();

        model.addAttribute("titulo", "Petición 2: Datos Estadísticos del Tamaño de las Listas");
        model.addAttribute("conteo", estadisticas.getCount());
        model.addAttribute("suma", estadisticas.getSum());
        model.addAttribute("promedio", estadisticas.getAverage());
        model.addAttribute("min", estadisticas.getMin());
        model.addAttribute("max", estadisticas.getMax());
        return "peticion2";
    }

    // Punto 3 / Petición 3: Aplanar todas las listas de dispositivos y obtener una lista de un atributo String (Marcas)
    @GetMapping("/peticion3")
    public String peticion3(Model model) {
        List<DispositivoInterface> objetos = repository.get12Objetos();

        List<Dispositivo> todosLosDispositivos = objetos.stream()
                .flatMap(o -> o.getDispositivos().stream())
                .collect(Collectors.toList());

        List<String> marcas = todosLosDispositivos.stream()
                .map(Dispositivo::getMarca)
                .collect(Collectors.toList());

        model.addAttribute("titulo", "Petición 3: Lista de Atributo String (Marcas de los Dispositivos)");
        model.addAttribute("marcas", marcas);
        model.addAttribute("totalDispositivos", todosLosDispositivos.size());
        return "peticion3";
    }

    // Punto 4 / Petición 4: Evaluaciones condicionales con anyMatch() y noneMatch()
    @GetMapping("/peticion4")
    public String peticion4(Model model) {
        List<DispositivoInterface> objetos = repository.get12Objetos();

        List<Dispositivo> todosLosDispositivos = objetos.stream()
                .flatMap(o -> o.getDispositivos().stream())
                .collect(Collectors.toList());

        boolean match1 = todosLosDispositivos.stream()
                .anyMatch(d -> d.getTipoConexion().equalsIgnoreCase("WiFi"));

        boolean match2 = todosLosDispositivos.stream()
                .anyMatch(d -> d.getEstado().equalsIgnoreCase("Inactivo"));

        boolean matchNone = todosLosDispositivos.stream()
                .noneMatch(d -> d.getConsumoVatios() > 1000);

        model.addAttribute("titulo", "Petición 4: Consultas con anyMatch() y noneMatch()");
        model.addAttribute("match1", match1);
        model.addAttribute("match2", match2);
        model.addAttribute("matchNone", matchNone);
        return "peticion4";
    }

    // Punto 5 / Petición 5: Objeto de la lista con el mayor valor de dato de tipo Integer (Mayor Consumo de Vatios)
    @GetMapping("/peticion5")
    public String peticion5(Model model) {
        List<DispositivoInterface> objetos = repository.get12Objetos();

        Dispositivo dispositivoMayorConsumo = objetos.stream()
                .flatMap(o -> o.getDispositivos().stream())
                .max(Comparator.comparingInt(Dispositivo::getConsumoVatios))
                .orElse(null);

        model.addAttribute("titulo", "Petición 5: Dispositivo con Mayor Valor de Consumo (Integer)");
        model.addAttribute("dispositivo", dispositivoMayorConsumo);
        return "peticion5";
    }
}
