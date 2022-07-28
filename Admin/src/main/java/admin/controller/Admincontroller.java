package admin.controller;

import java.util.Arrays;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import admin.model.Admin;
import admin.model.Bookingdetails;
import admin.model.CustomerRating;
//import admin.model.JwtRequest;
//import admin.model.JwtResponse;
import admin.model.Washers;
import admin.model.washpack;
//import admin.service.AdminServiceSecurity;
import admin.service.serviceImplementation;
import io.swagger.annotations.ApiOperation;


//@CrossOrigin(origins="http://localhost:3000")

@RestController
@RequestMapping("/admin")
public class Admincontroller {

	Logger logger = LoggerFactory.getLogger(Admincontroller.class);
	
    @Autowired
	private serviceImplementation service;

	@Autowired
	private RestTemplate restTemplate;
	

	// Admin operations
	@PostMapping("/addadmin")
	@ApiOperation(value = "Add new admins details")
	public String saveadmin(@RequestBody Admin admin)
	{
		service.saveadmin(admin);


		logger.info("An INFO Message");   //log levels confi msgs

		logger.error("An ERROR Message");
		return "Admin saved by ID:" + admin.getId();
	}

	@GetMapping("/alladmin")
	@ApiOperation(value = " to get the details of all admins ")
	public List<Admin> getadmin() {
		logger.trace("A TRACE Message");

		return service.findAll();

	}

	@PutMapping("/updateadmin")
	@ApiOperation(value = " Updates admin details")
	public String updateadmin(@RequestBody Admin admin) {
		service.saveadmin(admin);
		return "Admin updated successfully with Id:" + admin.getId();
	}

	/*@DeleteMapping("/deleteadmin")
	@ApiOperation(value = "Deletes Admin details")
	public String deleteadmin(@RequestParam int id) {
		service.deleteadmin(id);
		return "Sucessfully deleted admin";
	}*/

	// packs operations
	@GetMapping("/allpacks")
	@ApiOperation(value = "Shows Allpacks")
	public List<washpack> getwashpacks() {
		return service.getwashpack();

	}

	@PostMapping("/addpack")
	@ApiOperation(value = "Adds new pack")
	public String savepack(@RequestBody washpack p) {
		service.savepack(p);
		return "New pack added";
	}
	
	@PutMapping("/updatepack")
	@ApiOperation(value = "Update  pack")
	public String savepacku(@RequestBody washpack p) {
		service.savepack(p);
		logger.debug("A DEBUG Message");
		return "New pack added with id number"+p;
	}
	
	

	@DeleteMapping("/deletepack/{id}")
	@ApiOperation(value = "Deletes pack by Id")
	public String deletepack(@RequestParam int id) {
		service.deletepack(id);
		logger.warn("A WARN Message");
		return "pack deleted with id "+id;
	}
	
	

	// Ratings operations
	@PostMapping("/addratings")
	@ApiOperation(value = "Customer can add rating to washer")
	public String saveratings(@RequestBody CustomerRating rating) {
		service.save(rating);
		return "Thanks for your feedback";
	}

	@GetMapping("/allratings")
	@ApiOperation(value = "Gets all  customer ratings")
	public List<CustomerRating> getuser() {
		// TODO Auto-generated method stub
		return service.getuser();
	}

	/* --------------Resttemplates--------------------- */
	// bookings
	@GetMapping("/allorders")
	@ApiOperation(value = "To get all orders")
	public List<Bookingdetails> getorder() {
		String baseurl = "http://localhost:8081/order/allorders";
		Bookingdetails[] allorders = restTemplate.getForObject(baseurl, Bookingdetails[].class);
		return Arrays.asList(allorders);
	}

	// washers
	@GetMapping("/allwashers")
	@ApiOperation(value = "To find all washers")
	public List<Washers> findAllwashers() {
		String baseurl = "http://localhost:8085/wash/allwashers";
		Washers[] wash = restTemplate.getForObject(baseurl, Washers[].class);
		return Arrays.asList(wash);
	}

}
