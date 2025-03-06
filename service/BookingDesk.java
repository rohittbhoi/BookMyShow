package com.service;

import java.util.*;

import com.model.Movie;
import com.model.Snack;
import com.model.User;

public class BookingDesk implements BookMyShow {
    Scanner s = new Scanner(System.in);

    @Override
    public User loginUser(List<User> users) {
        System.out.print("Enter Username: ");
        String enteredUsername = s.next();
        System.out.print("Enter Password: ");
        String enteredPassword = s.next();

        for (User user : users) {
            if (user.getUserName().equals(enteredUsername) && user.getPassword().equals(enteredPassword)) {
                System.out.println("Login Donee! Welcome, " + user.getUserName() + "!");
                return user;
            }
        }
        System.out.println("Invalid Cred Inserted ! Please try again Later.");
        return null;
    }

    @Override
    public Movie bookTicket(List<Movie> mv) {
        System.out.println("Available Movies:");
        for (Movie movie : mv) {
            System.out.println("ID: " + movie.getId() + ", Name: " + movie.getName() +
                    ", Price: " + movie.getPrice() + ", Rating: " + movie.getRating());
        }

        System.out.print("Enter the movie ID you want to book: ");
        int movieId = s.nextInt();
        Movie selectedMovie = null;

        for (Movie movie : mv) {
            if (movie.getId() == movieId) {
                selectedMovie = movie;
                break;
            }
        }

        if (selectedMovie == null) {
            System.out.println("Invalid Movie Id , Try Different");
            return null;
        }

        System.out.print("Enter the number of seats for " + selectedMovie.getName() + ": ");
        int seats = s.nextInt();
        float totalAmount = (selectedMovie.getPrice() * seats);

        System.out.println("You have booked " + seats + " seats for " + selectedMovie.getName());
        System.out.println("Total Amount: ₹" + totalAmount);

        return selectedMovie;
    }

    @Override
    public List<Snack> addMeal(List<Snack> sn) {
        List<Snack> selectedSnacks = new ArrayList<>();
        System.out.println("Available Snacks:");
        for (Snack s : sn) {
            System.out.println(s.getId() + ". " + s.getName() + " - Rs. " + s.getPrice());
        }

        System.out.print("Enter snack ID to add or -1 to End : ");
        while (true) {
            int snackId = s.nextInt();
            if (snackId == -1) break;
            for (Snack snack : sn) {
                if (snack.getId() == snackId) {
                    selectedSnacks.add(snack);
                    System.out.println(snack.getName() + " added!");
                }
            }
        }
        return selectedSnacks;
    }

    @Override
    public void printDetails(Map<Integer, List<Object>> bookings) {
        int totalAmount = 0;
        for (Map.Entry<Integer, List<Object>> entry : bookings.entrySet()) {
            System.out.println("Booking ID: " + entry.getKey());
            for (Object item : entry.getValue()) {
                if (item instanceof Movie) {
                    Movie movie = (Movie) item;
                    System.out.println("Movie: " + movie.getName() + " | Price: " + movie.getPrice());
                    totalAmount += movie.getPrice();
                } else if (item instanceof Snack) {
                    Snack snack = (Snack) item;
                    System.out.println("Snack: " + snack.getName() + "| Price: " + snack.getPrice());
                    totalAmount += snack.getPrice();
                }
            }
        }
        System.out.println("Total Amount: " + totalAmount);
    }

    @Override
    public void logOut() {
        System.out.println("Logged out successfully!");
    }
}
