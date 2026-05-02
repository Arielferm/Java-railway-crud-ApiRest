package com.apirest.apirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {

    @Id // Atributo clave primaria de cada registro de "producto"
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia de creación autoincremental de id (para manejar automáticamente los id productos nuevos)
    
    // Atributos de la entidad "producto"
    private Long id;
    private String nombre;
    private Double precio;
    
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    } 




    
}
