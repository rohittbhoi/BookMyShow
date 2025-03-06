package com.user;

import java.util.*;

import com.model.Movie;
import com.model.Snack;
import com.model.User;
import com.service.BookMyShow;
import com.service.BookingDesk;

public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BookMyShow desk = new BookingDesk();
        List<Movie> movies = new ArrayList<>();
        List<Snack> snacks = new ArrayList<>();
        List<User> users = new ArrayList<>();
        Map<Integer, List<Object>> bookings = new LinkedHashMap<>();

        //  sample movies
        movies.add(new Movie(1, "Spider", 250, 4.8f, "Action"));
        movies.add(new Movie(2, "Valerian and Planets", 200, 4.7f, "Sci-Fi"));
        movies.add(new Movie(3, "Black Hole", 180, 4.5f, "Horror"));

        // sample snacks
        snacks.add(new Snack(1, "Popcorn", "Large", 150));
        snacks.add(new Snack(2, "Coke", "500ml ", 100));
        snacks.add(new Snack(3, "Chips", "Potato", 120));

        //  sample users
        users.add(new User("admin", "1234"));
        users.add(new User("rohit", "1234"));

        // login
        User loggedInUser = null;
        while (loggedInUser == null) {
            loggedInUser = desk.loginUser(users);
        }

        int bookingId = 1;

        while (true) {
            System.out.println("\n1. Book Ticket");
            System.out.println("2. Add Meal");
            System.out.println("3. Print Booking Details");
            System.out.println("4. Log Out");
            System.out.print("Enter choice: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    Movie bookedMovie = desk.bookTicket(movies);
                    if (bookedMovie != null) {
                        bookings.put(bookingId++, new ArrayList<>(List.of(bookedMovie)));
                    }
                    break;
                case 2:
                    if (!bookings.isEmpty()) {
                        List<Snack> selectedSnacks = desk.addMeal(snacks);
                        bookings.get(bookingId - 1).addAll(selectedSnacks);
                    } else {
                        System.out.println("Book the movie first!");
                    }
                    break;
                case 3:
                    desk.printDetails(bookings);
                    break;
                case 4:
                    desk.logOut();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
