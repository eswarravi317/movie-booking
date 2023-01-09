package TicketBooking;

public class Customer {
	static int id = 0;
	int customerId;
	int noOfTickets;
	String bookedMovie;
	double amountPaid;
	int[] sNumber;
	String alloted = "";
	
	Customer(int noOfTickets, String bookedMovie, double amountPaid, int[] sNumber){
		customerId = ++id;
		this.noOfTickets = noOfTickets;
		this.bookedMovie = bookedMovie;
		this.amountPaid = amountPaid;
		this.sNumber = sNumber;
		for(int i=0; i<noOfTickets; i++) {
			this.alloted += "S"+sNumber[i]+",";
		}
	}
}