package com.ibs.Expedia.Ass2.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.ibs.Expedia.Ass2.Model.Product;
import com.ibs.Expedia.Ass2.Repository.PoductRepository;
import com.ibs.Expedia.Ass2.Service.ServicesImplementation;

@RestController
public class ProductController {

	@Autowired
	PoductRepository productRepo;

	@Autowired
	ServicesImplementation services;

	@RequestMapping("/")
	public ModelAndView getHome() {
		ModelAndView mv = new ModelAndView("home.jsp");
		return mv;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/addProduct")
	@ResponseBody
	public String callAddProduct(Product product) {
		return services.addProduct(product);

	}

	// Using PostMan
	@RequestMapping(method = RequestMethod.PUT, value = "/updateById/{id}")
	@ResponseBody
	public String updateProduct(@RequestBody Product product, @PathVariable Long id) {
		return services.updateProduct(product, id);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllProduct")
	@ResponseBody
	public List callGetAll() {
		return services.getAllProduct();

	}

	// @RequestMapping("/getProduct{id}")
	// @RequestMapping(method=RequestMethod.GET,value="/getProduct{id}")
	@GetMapping("/getProduct{id}")
	@ResponseBody
	public ModelAndView callGetProduct(@RequestParam Long id) {
		if(id!=0) {
			return services.getProduct(id);
			
		}else {
			throw new ResourceNotFoundException("Resource not found");
		}

		
	}

	@RequestMapping("/deleteById{id}")
	@ResponseBody
	public String callDeleteById(@RequestParam Long id) {
		return services.DeleteById(id);
	}

	

}
