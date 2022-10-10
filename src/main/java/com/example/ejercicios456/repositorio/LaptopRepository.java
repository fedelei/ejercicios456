package com.example.ejercicios456.repositorio;

import com.example.ejercicios456.entidad.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Creando Repositorio, que hereda de JpaRepository
@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {


}
