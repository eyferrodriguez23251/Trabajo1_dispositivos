TRABAJO 1 - POLIMORFISMO

Proyecto Spring Boot basado en el documento del Trabajo 1 y las diapositivas de clase.

Dependencias utilizadas:
- Spring Boot DevTools
- Spring Web
- Thymeleaf

Tema asignado:
Conectar dispositivo.

Estructura:
- modelo: interfaces y clases del dominio.
- controlador: peticiones y procesamiento de los objetos.
- templates: vista HTML con Thymeleaf.

Tres interfaces:
1. Conectar -> String conectar(Dispositivo)
2. Transmitir -> String transmitir(Dispositivo)
3. Desconectar -> String desconectar(Dispositivo)

Interface definitiva:
DispositivoInterface extends Conectar, Transmitir, Desconectar

Clases concretas:
- Wifi
- Bluetooth
- Cable

Polimorfismo:
- Se crean 9 objetos: 3 Wifi, 3 Bluetooth y 3 Cable.
- Cada objeto recibe un Dispositivo en su constructor.
- Los 9 objetos se almacenan en una lista de tipo DispositivoInterface.
- El controlador itera la lista con un for.
- Se llaman los tres métodos heredados: conectar(), transmitir() y desconectar().
- Cada clase concreta ejecuta su propia implementación de los tres métodos.
- Los resultados se envían al HTML mediante Thymeleaf.

El main:
El método main solamente inicia Spring Boot. No contiene los procedimientos del ejercicio.

Para ejecutar:
1. Abrir esta carpeta en IntelliJ IDEA.
2. Verificar que esté configurado Java 21.
3. Esperar a que Maven descargue las dependencias.
4. Ejecutar Trabajo1PolimorfismoApplication.
5. Abrir http://localhost:8080/

Nota:
La interfaz definitiva utiliza "extends" para heredar de las tres interfaces, tal como se explica en las diapositivas. Las clases concretas utilizan "implements" para implementar la interfaz definitiva.
