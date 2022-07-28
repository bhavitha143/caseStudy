package com.customer.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ratingdb")
public class CustomerRating
{
	
	     private String name;
		 private int rating;
		 private String review;
		public CustomerRating()
		{
			super();
		}
		public CustomerRating(String washername, int rating, String review)
		{
			super();
			this.name = washername;
			this.rating = rating;
			this.review = review;
		}
		public String getName()
		{
			return name;
		}
		public void setName(String name)
		{
			this.name = name;
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating)
		{
			this.rating = rating;
		}
		public String getReview()
		{
			return review;
		}
		public void setReview(String review)
		{
			this.review = review;
		}
		@Override
		public String toString()
		{
			return "CustomerRating [washername=" + name + ", rating=" + rating + ", review=" + review + "]";
		}
		 
		
}