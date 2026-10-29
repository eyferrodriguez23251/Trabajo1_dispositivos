package com.ejemplo.polimorfismo.interfaz;

import com.ejemplo.polimorfismo.modelo.Dispositivo;
import java.util.List;

public interface DispositivoInterface extends Conectar, Transmitir, Desconectar {

    String getNombre();

    List<Dispositivo> getDispositivos();
}
