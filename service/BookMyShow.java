package com.service;

import java.util.List;
import java.util.Map;
import com.model.Movie;
import com.model.Snack;
import com.model.User;

public interface BookMyShow {
    User loginUser(List<User> users); // Login method
    Movie bookTicket(List<Movie> movies);  // Book movie ticket
    List<Snack> addMeal(List<Snack> snacks); // Add snacks
    void printDetails(Map<Integer, List<Object>> bookings); // Print booking details
    void logOut(); // Logout
}
