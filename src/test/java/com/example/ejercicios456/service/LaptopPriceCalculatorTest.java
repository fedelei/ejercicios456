package com.example.ejercicios456.service;

import com.example.ejercicios456.entidad.Laptop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaptopPriceCalculatorTest {

    @Test
    void calculatePrice() {
        Laptop laptop = new Laptop(1L, "Acer", "v5", "Silver", "Windows 10", 250.00);
        LaptopPriceCalculator calculadora = new LaptopPriceCalculator();
        double precio = calculadora.calculatePrice(laptop);
        System.out.println(precio);

        assertTrue(precio > 0);
    }
}