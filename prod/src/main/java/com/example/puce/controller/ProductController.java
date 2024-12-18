package com.example.puce.controller;

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

import com.example.puce.model.Producto;
import com.example.puce.service.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")

public class ProductController {
	
	@Autowired
	private ProductoService productoService;
	
	//listar productos lectura
	@GetMapping
	public List<Producto> listarProductos()
	{
	return productoService.getProductos();	
		
	}
	
	@PostMapping
	//crear o guardar un producto
	public Producto agregarProducto (@RequestBody Producto producto) //request body recibe en formato JSON
	//y transforma en una entidad normal
	{
		return productoService.saveProducto(producto);
	}
	
	//obtener producto
	@GetMapping ("/{id}")
	//pasar el producto que se va a obtener
	public Producto buscarProducto (@PathVariable int id)
	{
		return productoService.getProductoById(id);
		
	}
	//
	@PutMapping
	//Request body recibe como parametro un json
	public Producto actualizarProducto (@RequestBody Producto producto)
	{
		return productoService.updateProducto(producto);
		
	}
	
	@DeleteMapping("/{id}")
	
	public String eliminarProducto (@PathVariable int id)
	{
		return productoService.deleteProducto(id);
		
	}
	
}
