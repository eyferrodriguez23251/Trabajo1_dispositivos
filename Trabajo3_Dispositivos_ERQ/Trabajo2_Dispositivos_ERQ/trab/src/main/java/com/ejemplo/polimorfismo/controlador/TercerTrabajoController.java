package com.ejemplo.polimorfismo.controlador;

import com.ejemplo.polimorfismo.modelo.Categoria;
import com.ejemplo.polimorfismo.modelo.DispositivoTrabajo3;
import com.ejemplo.polimorfismo.modelo.RedDispositivos;
import com.ejemplo.polimorfismo.modelo.TipoDispositivoEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class TercerTrabajoController {

    @GetMapping("/tercer-trabajo")
    public String mostrarTercerTrabajo(Model model) {
        Stack<DispositivoTrabajo3> dispositivosStack = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            Stack<Integer> conteo = new Stack<>();
            conteo.addAll(List.of(i, i + 1, i + 2));
            dispositivosStack.push(new DispositivoTrabajo3(
                    "Dispositivo " + i, "Marca " + i, "Modelo " + i,
                    TipoDispositivoEnum.COMPUTADOR, Categoria.HOGAR, conteo));
        }

        Deque<DispositivoTrabajo3> dequeDesdeStack = new ArrayDeque<>(dispositivosStack);
        RedDispositivos red = new RedDispositivos("Red principal", "Laboratorio",
                TipoDispositivoEnum.COMPUTADOR, Categoria.HOGAR, new ArrayDeque<>());
        for (DispositivoTrabajo3 dispositivo : dequeDesdeStack) {
            red.agregarDispositivo(dispositivo);
        }

        List<String> stackConListIterator = new ArrayList<>();
        var listIterator = dispositivosStack.listIterator();
        while (listIterator.hasNext()) {
            DispositivoTrabajo3 d = listIterator.next();
            stackConListIterator.add(d.toString());
        }

        List<String> dequeConIterator = new ArrayList<>();
        Iterator<DispositivoTrabajo3> iterator = red.getDispositivos().iterator();
        while (iterator.hasNext()) {
            dequeConIterator.add(iterator.next().toString());
        }

        List<String> filtrados = red.getDispositivos().stream()
                .filter(d -> d.getTipo() == TipoDispositivoEnum.COMPUTADOR)
                .map(DispositivoTrabajo3::toString)
                .collect(Collectors.toList());

        Function<DispositivoTrabajo3, Integer> sumarConteo =
                d -> d.getConteo().stream().mapToInt(Integer::intValue).sum();
        List<String> totales = new ArrayList<>();
        for (DispositivoTrabajo3 d : dispositivosStack) {
            totales.add(d.getNombre() + ": " + sumarConteo.apply(d));
        }
        dispositivosStack.peek().verTotales(sumarConteo);

        model.addAttribute("enumTipos", TipoDispositivoEnum.values());
        model.addAttribute("enumCategorias", Categoria.values());
        model.addAttribute("stackObjetos", stackConListIterator);
        model.addAttribute("dequeObjetos", dequeConIterator);
        model.addAttribute("filtrados", filtrados);
        model.addAttribute("totales", totales);
        model.addAttribute("red", red);
        return "tercer-trabajo";
    }
}
