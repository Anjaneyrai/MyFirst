package com.sample.postgress.service;
import org.springframework.stereotype.Component;

import com.sample.postgress.entity.Agreement_Detail;
import com.sample.postgress.entity.Message;
import com.sample.postgress.entity.Product;

import java.util.List;

import javax.annotation.Resource;
import com.sample.postgress.dao.ProductDao;
@Component
public class ProductServiceImpl implements ProductService {
@Resource
ProductDao productdao;

@Override
public List<Product> findAll() {
	return productdao.findAll();
}

@Override
public void insert(Product p) {
	// TODO Auto-generated method stub
	productdao.insert(p);
}

@Override
public void update(Product p) {
	// TODO Auto-generated method stub
	productdao.update(p);
}

@Override
public void delete(Product p) {
	// TODO Auto-generated method stub
	productdao.update(p);
}

@Override
public Product getProduct(int id) {

	return productdao.getProduct(id);
}

@Override
public List<Message> initiateAgreement(int product_id, String email, double price,String password) {
return productdao.initiateAgreement( product_id,email,price,password);
}

@Override
public List<Agreement_Detail> getAll(int name) {
	
	return productdao.getAll(name);
}

@Override
public List<Message> accept(int name,int agreement,String email,String pass) {
	
	return productdao.accept(name,agreement,email,pass);
}

@Override
public Message reject(int name, int agreement, String email, String password) {
	
	return productdao.reject(name,agreement,email,password);
}


}
