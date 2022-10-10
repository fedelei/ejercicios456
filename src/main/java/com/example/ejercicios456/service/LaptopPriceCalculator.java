package com.example.ejercicios456.service;

import com.example.ejercicios456.entidad.Laptop;

public class LaptopPriceCalculator {
    public double calculatePrice(Laptop laptop){
        double price = laptop.getPrecio();

        if (laptop.getPrecio() > 200) {
            price -= 20; //Descuento Promocional
        }
        return price;
    }
}
