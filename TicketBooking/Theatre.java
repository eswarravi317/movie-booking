package TicketBooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Theatre {
	static int id = 0;
	int movieId;
	String movie;
	int tickets;
	double price;
	
	List<Integer> seatNo = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	static HashMap<Integer, Customer> bookedCustomer;
//	static HashMap<Integer, Customer> bookedDetails;
	
	Theatre(String movie){
		movieId = ++id;
		this.movie = movie;
		tickets = 10;
		price = 500;
		bookedCustomer = new HashMap<Integer, Customer>();
//		bookedDetails = new HashMap<Integer, Customer>();
	}
	
	public Theatre() {
		// TODO Auto-generated constructor stub
	}

	public void showMovies() {
		System.out.println(movie +"-> Total available tickets are "+ tickets);
	}
	
	public static void bookTicket(Theatre currentMovie) {
		Theatre t = new Theatre();
		if(currentMovie != null) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter no of tickets: ");
			int noOfTickets = sc.nextInt();
			if(currentMovie.tickets>=noOfTickets) {
				int[] seats = new int[noOfTickets];
				for(int i=0; i<noOfTickets; i++) {
					seats[i] = t.seatNo.get(0);
					t.seatNo.remove(0);
				}
				Customer c = new Customer(noOfTickets, currentMovie.movie, (noOfTickets*currentMovie.price), seats);
//				bookedDetails.put(currentMovie.movieId, c);
					
				bookedCustomer.put(c.customerId, c);
				currentMovie.tickets -= noOfTickets;
				
				System.out.println("\nCustomer ID: "+c.customerId+"\nMovie name: "+ currentMovie.movie+"\nNo of tickets: "+noOfTickets
						+"\nAmount paid: "+ (noOfTickets*currentMovie.price)
						+"\nSeats: "+ c.alloted.substring(0, c.alloted.length()-1));
				System.out.println("--------------Booked successfully");
				
			}
			else {
				System.out.println("No tickets available");
			}
		}
		else {
			System.out.println("No data");
		}
	}
	
	public static void viewTicket(int id) {
		boolean found = false;
		for(Integer c: bookedCustomer.keySet()) {
			if(id == c) {
				found = true;
				System.out.println("------------Ticket-------------");
				System.out.println("Customer ID: "+bookedCustomer.get(c).customerId+"\nMovie name: "+ bookedCustomer.get(c).bookedMovie+"\nNo of tickets: "+bookedCustomer.get(c).noOfTickets
						+"\nAmount paid: "+ (bookedCustomer.get(c).amountPaid)
						+"\nSeats: "+ bookedCustomer.get(c).alloted.substring(0, bookedCustomer.get(c).alloted.length()-1)+"\n----------------------------------------------");
			}
		}
		if(!found) {
			System.out.println("No customer found");
		}
	}
	
	public static void cancelTicket(int id, Theatre currentMovie) {
		boolean found = false;
		for(Integer c: bookedCustomer.keySet()) {
			if(id == c && currentMovie.movie.equals(bookedCustomer.get(c).bookedMovie)) {
				found = true;
				for(int i=0; i<bookedCustomer.get(c).sNumber.length; i++) {
					currentMovie.seatNo.add(bookedCustomer.get(c).sNumber[i]);
				}
				currentMovie.tickets += bookedCustomer.get(c).noOfTickets;
				System.out.println("Refundable amount: "+ bookedCustomer.get(c).amountPaid);
				System.out.println("---------------Ticket cancelled successfully");
				bookedCustomer.remove(c);
			}
		}
		if(!found) {
			System.out.println("No customer found");
		}
	}
	
}