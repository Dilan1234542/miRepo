package com.example.puce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.puce.model.Producto;
import com.example.puce.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public Producto saveProducto(Producto producto) 
	{
		return productoRepository.save(producto);
		
	}
	//listar todos los productos
	public List<Producto> getProductos()
	{
		return productoRepository.getAllProductos();
		
	}
	//buscar producto
	public Producto getProductoById (int id)
	{
		return productoRepository.findById(id);
		
	}
	
	//borrar producto
	public String deleteProducto (int id)
	{
		productoRepository.delete(id);
		return "Producto eliminado " + id;
		
	}
	
	//actualizar producto
	
	public Producto updateProducto (Producto producto)
	{
	return productoRepository.update(producto);
		
	}

}
