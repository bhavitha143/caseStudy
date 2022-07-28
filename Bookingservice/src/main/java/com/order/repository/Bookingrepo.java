package com.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;
@Repository
public interface Bookingrepo  extends MongoRepository<com.order.model.Bookingdetails, Integer>{
	
	boolean save(int id);


	
	

}
