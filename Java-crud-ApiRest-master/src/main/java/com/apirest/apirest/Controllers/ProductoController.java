// direcciones y urls para consumir info con clientes (sirve para leer, escribir, borrar y actualizar "productos")
package com.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.apirest.Entities.Producto;
import com.apirest.apirest.Repositories.ProductoRepository;

@RestController //API REST
@RequestMapping("/productos") // ruta donde va ir la URL para ingresar a los productos en base de datos
public class ProductoController {

    @Autowired                                  //Inyección de dependencia para usar el repositorio de productos
    private ProductoRepository productoRepository;

    @GetMapping                                 //mapeo de solicitudes para leer datos
    public List<Producto> getAllProductos() { 
        return productoRepository.findAll();    //devuelve todos los productos de la base de datos
    }
 
    @GetMapping("/{id}") 
    public Producto getProductoById(@PathVariable Long id) { //recibe el id del producto en la URL
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id)); //buscar el producto por id, si no existe lanza una excepción
    }                    


    @PostMapping                                //mapeo de solicitudes para crear datos
    public Producto createProducto(@RequestBody Producto producto) { //recibe el producto en el cuerpo (@RequestBody) de la solicitud
        return productoRepository.save(producto); //guardar un nuevo producto en la base de datos
    }

    @PutMapping("/{id}") 
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id)); //buscar el producto por id, si no existe lanza una excepción

        //actualizar los detalles del producto
        producto.setNombre(productoDetails.getNombre());
        producto.setPrecio(productoDetails.getPrecio());

        return productoRepository.save(producto); //guardar los cambios en la base de datos   
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id)); //buscar el producto por id, si no existe lanza una excepción
        
        productoRepository.delete(producto); //eliminar el producto de la base de datos
        return "El producto con ID:" + id + " fue eliminado con éxito";
    }

}
