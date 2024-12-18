package com.example.puce.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.puce.model.Producto;

@Repository
public class ProductoRepository {

	
	private List<Producto> productos = new ArrayList<>();
	
	 //Listar todos los productos
    public List<Producto> getAllProductos(){
        return productos;
    }

    //Buscar un producto
    public Producto findById(int id){
        for(int i = 0;i < productos.size();i++){
            if(productos.get(i).getId() == id){
                return productos.get(i);
            }
        }
        return null;
    }
    
    //Guardamos un produto en la lista
    public Producto save(Producto p){
        Producto producto = new Producto();
        producto.setId(p.getId());
        producto.setNombre(p.getNombre());
        producto.setCantidad(p.getCantidad());
        producto.setPrecio(p.getPrecio());

        productos.add(producto);
        return producto;
    }

    //Eliminamos un producto
    public String delete(Integer id){
        productos.removeIf(x -> x.getId() == id);
        return null;
    }
    
    //actualizar un producto
    public Producto update(Producto producto){
        int idPos = 0;
        int id = 0;

	     //comprobamos si existe el producto y obtenemos la posicion y ID del producto
	        for(int i = 0;i < productos.size();i++){
	            if(productos.get(i).getId() == (producto.getId())){
	                id = producto.getId(); //ID del producto
	                idPos = i; //posicion
	                break;
	            }
	        }
	        //creamos un nuevo producto para actualizar
	        Producto productoact = new Producto();
	        productoact.setId(id);
	        productoact.setNombre(producto.getNombre());
	        productoact.setCantidad(producto.getCantidad());
	        productoact.setPrecio(producto.getPrecio());
	        productos.set(idPos,producto);
	        return productoact;
	    }
	
}
