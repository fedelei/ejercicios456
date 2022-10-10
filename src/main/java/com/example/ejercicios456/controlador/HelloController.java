package com.example.ejercicios456.controlador;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hola")
    public String holaMundo(){
        return "Hola mi pajarito, estas ingresando a mi primer pagina API de manera remota, PAPI TE AMA MUCHO";
    }
}
