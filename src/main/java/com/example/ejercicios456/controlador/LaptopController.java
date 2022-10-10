package com.example.ejercicios456.controlador;

import com.example.ejercicios456.entidad.Laptop;
import com.example.ejercicios456.repositorio.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;


@RestController
public class LaptopController {
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository)
    {
        this.laptopRepository = laptopRepository;
    }
    //Mostrar todos los obejetos Laptops
    @GetMapping("/api/laptops")
    @ApiOperation("Busca todas las Laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    //Buscar un objeto en particular
    @GetMapping("/api/laptops/{id}")
    @ApiOperation("Busca una Laptop en particular")
    public ResponseEntity<Laptop> findById(@PathVariable Long id){
        Optional<Laptop> laptOpt = laptopRepository.findById(id);
        if(laptOpt.isPresent())
            return ResponseEntity.ok(laptOpt.get());
        else
            return ResponseEntity.notFound().build();

    }

    //Creando Objeto Laptop desde Postman.
    @PostMapping("/api/laptops")
    @ApiOperation("Crea una Laptop")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop) {
        if (laptop.getId() != null) {
            log.warn("Esta intentando crear un objeto con ID");
            return ResponseEntity.badRequest().build();
        }
        Laptop lapt = laptopRepository.save(laptop);
        return ResponseEntity.ok(lapt);

    }

    //Actualizando objeto.
    @PutMapping("/api/laptops")
    @ApiOperation("Actualiza una Laptop")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if (laptop.getId() == null){
            log.warn("El objeto a actualizar no existe");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())){
            log.warn("El ID a actualizar no existe");
            return ResponseEntity.notFound().build();
        }
        Laptop lp = laptopRepository.save(laptop);
        return ResponseEntity.ok(lp);
    }
    // Eliminando OBJETO por ID
    @DeleteMapping("/api/laptops/{id}")
    @ApiOperation("Elimina una Laptop en particular")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if (!laptopRepository.existsById(id)){
            log.warn("El ID borrar no existe");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Eliminando todos los objetos
    @DeleteMapping("/api/laptops")
    @ApiOperation("Elimina todas las laptops")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
       return ResponseEntity.noContent().build();
    }
}
