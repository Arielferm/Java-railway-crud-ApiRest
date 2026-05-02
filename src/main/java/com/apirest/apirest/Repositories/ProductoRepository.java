package com.apirest.apirest.Repositories;

import com.apirest.apirest.Entities.Producto;

import org.springframework.data.jpa.repository.JpaRepository;

//Extiende JpaRepository para proporcionar operaciones CRUD para la entidad "Producto" <Entidad:Producto, Id:Long/int>
public interface ProductoRepository extends JpaRepository<Producto, Long> { 

}
