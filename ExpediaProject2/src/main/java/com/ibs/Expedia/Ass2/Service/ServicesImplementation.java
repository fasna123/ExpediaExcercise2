package com.ibs.Expedia.Ass2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ibs.Expedia.Ass2.Model.Product;
import com.ibs.Expedia.Ass2.Repository.PoductRepository;

@Service
public class ServicesImplementation implements ServiceInterface {
	@Autowired
	PoductRepository productRepo;

	public String home() {
		return "home.jsp";
	}

//1. For saving product to db	
	public String addProduct(Product product) {
		productRepo.save(product);
		return "Saved Product";
	}

//2.For updating product in db

	public String updateProduct(Product product, Long id) {
		List<Product> products = (List<Product>) productRepo.findAll();
		Optional<Product> optionalProduct = Optional
				.of(products.stream().filter(t -> t.getId() == id).findFirst().get());
		if (!optionalProduct.isPresent()) {
			throw new ResourceNotFoundException("Not present with this id");

		} else {
			Product updatedProduct = optionalProduct.get();
			updatedProduct.setId(product.getId());
			updatedProduct.setProductName(product.getProductName());
			updatedProduct.setProductDesc(product.getProductDesc());
			updatedProduct.setProductPrice(product.getProductPrice());
			productRepo.save(updatedProduct);
			return "Updated The product";
		}

	}

//3.For getting all products from db	
	public List<Product> getAllProduct() {
		
		return (List) productRepo.findAll();
	}

//4.For getting product based on id from db		
	public ModelAndView getProduct(@RequestParam Long id) throws ResourceNotFoundException {
		ModelAndView mv = new ModelAndView("FetchProduct.jsp");
		Product product = productRepo.findById(id).orElse(new Product());
		mv.addObject(product);
		return mv;
	}

//5.For deleting product from db	
	public String DeleteById(Long id) throws ResourceNotFoundException {
		
		List<Product> product = (List<Product>) productRepo.findAll();
		Product newProduct = product.stream().filter(t -> t.getId() == id).findFirst().get();
		productRepo.delete(newProduct);
		return "Deleted The product with id :" + id + " successfully";
	}

}
