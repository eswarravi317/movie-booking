package TicketBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Theatre> theatreDetails = new ArrayList<Theatre>();
	
	public static void initialize() {
		theatreDetails.add(new Theatre("Aranmanai"));
		theatreDetails.add(new Theatre("Visaranai"));
		theatreDetails.add(new Theatre("Muni"));
		theatreDetails.add(new Theatre("Velaikkaran"));
	}
	
	public static void main(String[] args) {
		
		if(theatreDetails.size() == 0) {
			initialize();
		}
		
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.print("1.Show Movies\n2.BookTicket\n3.View Ticket\n4.Cancel Ticket\nEnter choice: ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				for(Theatre td1: theatreDetails) {
					td1.showMovies();
				}
				System.out.println("------------------");
				break;
			case 2:
				System.out.print("1 -> Aranmanai\n2 -> Visaranai\n3 -> Muni\n4 -> Velaikaran\nSelect movie: ");
				int id = sc.nextInt();
				Theatre currentMovie = null;
				for(Theatre td2: theatreDetails) {
					if(id == td2.movieId) {
						currentMovie = td2;
					}
				}
				Theatre.bookTicket(currentMovie);
				break;
			case 3:
				System.out.print("Enter customer id: ");
				int cId = sc.nextInt();
				Theatre.viewTicket(cId);
				break;
			case 4:
				System.out.print("1 -> Aranmanai\n2 -> Visaranai\n3 -> Muni\n4 -> Velaikaran\nSelect movie: ");
				int mId = sc.nextInt();
				Theatre currentMovieForCancel = null;
				for(Theatre td2: theatreDetails) {
					if(mId == td2.movieId) {
						currentMovieForCancel = td2;
					}
				}
				System.out.print("Enter customer id: ");
				int cancelId = sc.nextInt();
				Theatre.cancelTicket(cancelId, currentMovieForCancel);
				break;
			}
		}
		
	}
}