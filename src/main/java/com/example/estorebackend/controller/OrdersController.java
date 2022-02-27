package com.example.estorebackend.controller;

import java.util.ArrayList;
import java.util.Date;

import com.example.estorebackend.model.Orders;
import com.example.estorebackend.model.Response;
import com.example.estorebackend.repository.OrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {

  @Autowired
	OrdersRepository repository;
	
	final String TAG = "Order";
	
	@PostMapping(path= "/add")
	public Response<Orders> addOrder(@RequestParam Date orderDate, @RequestParam String orderStatus, @RequestParam Integer totalItems,
      @RequestParam Double itemsSubTotal, @RequestParam Double shipmentCharges, @RequestParam Double totalAmount, @RequestParam Integer paymentStatus,
      @RequestParam String paymentStatusTitle, @RequestParam Integer paymentMethod, @RequestParam String paymentMethodTitle, @RequestParam Integer userId, @RequestParam String name,
      @RequestParam String email, @RequestParam Long contact, @RequestParam String address) {
		Date date = new Date();
		
		Orders order = new Orders(null, orderDate, orderStatus, totalItems, itemsSubTotal, shipmentCharges, totalAmount, paymentStatus, paymentStatusTitle, paymentMethod, paymentMethodTitle, userId, name, email, contact, address);
		repository.save(order);
		
		return new Response<Orders>(101, TAG+" Saved Successfully at "+date, null);
		
	}
	
	@GetMapping(path="/get")
	public Response<Orders> getOrders(){
		
		ArrayList<Orders> list = new ArrayList<Orders>();
		repository.findAll().forEach((order) -> list.add(order));
		
		Date date = new Date();
		return new Response<Orders>(101, list.size()+" "+TAG+"s Fetched Successfully at "+date, list);
		
	}
	

	@GetMapping(path = "/get/{id}")
	public Response<Orders> getOrderById(@PathVariable("id") Integer id){
		
		ArrayList<Orders> list = new ArrayList<Orders>();
		Orders order = repository.findById(id).get();
		list.add(order);
		
		Date date = new Date();
		return new Response<Orders>(101, TAG+" Fetched Successfully at "+date, list);
		
	}
	
	@PostMapping(path= "/update")
	public Response<Orders> updateOrder(@RequestParam Integer orderId, @RequestParam Date orderDate, @RequestParam String orderStatus, @RequestParam Integer totalItems,
    @RequestParam Double itemsSubTotal, @RequestParam Double shipmentCharges, @RequestParam Double totalAmount, @RequestParam Integer paymentStatus,
    @RequestParam String paymentStatusTitle, @RequestParam Integer paymentMethod, @RequestParam String paymentMethodTitle, @RequestParam Integer userId, @RequestParam String name,
    @RequestParam String email, @RequestParam Long contact, @RequestParam String address) {

		
		Date date = new Date(); 
		
		Orders order = new Orders(orderId, orderDate, orderStatus, totalItems, itemsSubTotal, shipmentCharges, totalAmount, paymentStatus, paymentStatusTitle, paymentMethod, paymentMethodTitle, userId, name, email, contact, address);
		repository.save(order);
		
		return new Response<Orders>(101, TAG+" Updated Successfully at "+date, null);
		
	}
	
	@GetMapping(path = "/delete/{id}")
	public Response<Orders> deleteOrder(@PathVariable("id") Integer id){
		
		Orders order = new Orders();
		order.setOrderId(id);
		repository.delete(order);
		
		Date date = new Date();
		return new Response<Orders>(101, TAG+" Deleted Successfully at "+date, null);
		
	}
}
