package com.sample.postgress.dao;
import java.util.List;

import com.sample.postgress.entity.Agreement_Detail;
import com.sample.postgress.entity.Message;
import com.sample.postgress.entity.Product;
public interface ProductDao {
	List<Product>findAll();
	void insert(Product  p);

	void update(Product p);

	void delete(Product p);
	
	Product getProduct(int id);
	List<Message> initiateAgreement(int product_id, String email,double price,String pass);
	List<Agreement_Detail> getAll(int name);
	Message accept(int id,int agreement,String email,String password);
	Message reject(int id,int agreement,String email,String password);
}
