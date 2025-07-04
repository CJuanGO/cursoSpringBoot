package cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @restcontroler se usa para marcar una clase controlador y mapea los metodos a una ruta html
@RestController
public class HelloWorldRestController {


    // mapea solicitudes en http, asigna solicitudes htt get a metodos de controlador
    @GetMapping ({"/hello"})
    public String helloWorld(){
        System.out.println("solicitud ejecutada");
        return "Hello world";
    }


}


