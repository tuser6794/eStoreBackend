package com.example.estorebackend.controller;

import java.util.ArrayList;
import java.util.Date;

import com.example.estorebackend.model.OrderItems;
import com.example.estorebackend.model.Response;
import com.example.estorebackend.repository.OrderItemsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderitems")
public class OrderItemsController {

  @Autowired
	OrderItemsRepository repository;
	
	final String TAG = "Categories";
	
	@PostMapping(path= "/add")
	public Response<OrderItems> addOrderItem(@RequestParam Integer orderId, @RequestParam Integer productId, @RequestParam String productTitle,
  @RequestParam String productDescription, @RequestParam String productCode, @RequestParam String productImg, @RequestParam String productCategory, @RequestParam Integer price,
  @RequestParam Integer quantity, @RequestParam Integer totalPrice) {
		Date date = new Date();
		
		OrderItems category = new OrderItems(null, orderId, productId, productTitle, productDescription, productCode, productImg, productCategory, price, quantity, totalPrice);
		repository.save(category);
		
		return new Response<OrderItems>(101, TAG+" Saved Successfully at "+date, null);
		
	}
	
	@GetMapping(path="/get")
	public Response<OrderItems> getAllOrderItems(){
		
		ArrayList<OrderItems> list = new ArrayList<OrderItems>();
		repository.findAll().forEach((category) -> list.add(category));
		
		Date date = new Date();
		return new Response<OrderItems>(101, list.size()+" "+TAG+"s Fetched Successfully at "+date, list);
		
	}
	

	@GetMapping(path = "/get/{id}")
	public Response<OrderItems> getorderItemByOrderId(@PathVariable("id") Integer id){
		
		ArrayList<OrderItems> list = new ArrayList<OrderItems>();
		OrderItems category = repository.findById(id).get();
		list.add(category);
		
		Date date = new Date();
		return new Response<OrderItems>(101, TAG+" Fetched Successfully at "+date, list);
		
	}
	
	@PostMapping(path= "/update")
	public Response<OrderItems> updateOrderItem(@RequestParam Integer orderItemId, @RequestParam Integer orderId, @RequestParam Integer productId, @RequestParam String productTitle,
  @RequestParam String productDescription, @RequestParam String productCode, @RequestParam String productImg, @RequestParam String productCategory, @RequestParam Integer price,
  @RequestParam Integer quantity, @RequestParam Integer totalPrice) {

		
		Date date = new Date();
		
		OrderItems category = new OrderItems(orderItemId, orderId, productId, productTitle, productDescription, productCode, productImg, productCategory, price, quantity, totalPrice);
		repository.save(category);
		
		return new Response<OrderItems>(101, TAG+" Updated Successfully at "+date, null);
		
	}
	
	@GetMapping(path = "/delete/{id}")
	public Response<OrderItems> deleteOrderItem(@PathVariable("id") Integer id){
		
		OrderItems category = new OrderItems();
		category.setOrderItemId(id);
		repository.delete(category);
		
		Date date = new Date();
		return new Response<OrderItems>(101, TAG+" Deleted Successfully at "+date, null);
		
	}
}
