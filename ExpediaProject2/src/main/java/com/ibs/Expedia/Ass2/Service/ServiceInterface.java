package com.ibs.Expedia.Ass2.Service;

import java.util.List;


import org.springframework.web.servlet.ModelAndView;

import com.ibs.Expedia.Ass2.Model.Product;

public interface ServiceInterface {
	public String addProduct(Product product);
	public String updateProduct(Product product, Long id);
	public List<Product> getAllProduct();
	public ModelAndView getProduct(Long id);
	public String DeleteById(Long id);
}
