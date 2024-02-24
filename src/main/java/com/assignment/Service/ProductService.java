package com.assignment.Service;

import java.util.List;

import com.assignment.Exception.ProductException;
import com.assignment.Model.Product;

public interface ProductService {
	
	public Product addProduct(Product product) throws ProductException;
	
	public Product deleteProduct(Integer productId) throws ProductException;
	
	public Product updateProduct(Integer productId,Integer productPrice) throws ProductException;
	
	public Product viewProduct(Integer productId) throws ProductException;
	
	public List<Product> viewAllProducts() throws ProductException;

}
