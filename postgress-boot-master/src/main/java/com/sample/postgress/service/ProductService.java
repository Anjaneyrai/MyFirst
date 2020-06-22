package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Agreement_Detail;
import com.sample.postgress.entity.Message;
import com.sample.postgress.entity.Product;
public interface ProductService{
	List<Product>findAll();
	void insert(Product  p);

	void update(Product p);

	void delete(Product p);
	
    Product getProduct(int id);
	List<Message> initiateAgreement(int name, String email, double price,String password);
	List<Agreement_Detail> getAll(int name);
	List<Message> accept(int name,int agreement,String email,String password);
	List<Message> reject(int name,int agreement,String email,String password);
}