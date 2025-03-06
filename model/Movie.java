package com.model;

public class Movie {
	private int id; 
	private String name; 
	private int price; 
	private float rating; 
	private String genre; 
	
	
	public Movie(int id , String name , int price , float rating , String genre) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.genre = genre;
	}
	//1 
	public void setId(int id) {
		this.id = id ;
	}
	public int getId() {
		return id;
	}
	
	//2
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	//3
	public void setPrice(int price) {
		this.price = price;
	}
	
	public float getPrice() {
		return price;
	}
	
	//4 
	
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	public float getRating () {
		return rating;
	}
	
	//5 
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getGenre() {
		return genre;
	}
	@Override
	public String toString() {
		return "Movie id=" + id + ", name=" + name + ", price=" + price + ", rating=" + rating + ", genre=" + genre;
	}
	
	

	
}
