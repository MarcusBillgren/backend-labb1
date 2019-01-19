
import java.util.Scanner;

import com.mashape.unirest.http.exceptions.UnirestException;

public class MovieService {

	public static void main(String[] args) throws UnirestException {
		
		Scanner sc = new Scanner(System.in);
		MovieParser mp = new MovieParser();
		int selection = 0;
		System.out.println( "Time to consume the TMDB API" );
		
		while(true) {

		System.out.println( "Please enter a movie id to get from database: " );
		
		selection = sc.nextInt();
		
		if(selection == 0)
			break;
		//clear scanner selection
		sc.nextLine();
		//print info in super stylish fashion
		System.out.println("****** MOVIE INFO ******\n");
		System.out.println( mp.getMovie( selection ) ); // would work as well ---> mp.getMovieData( selection )
		System.out.println("******END OF MOVIE INFO ******\n");
		System.out.println( "Enter 0 to quit:" );

		}

	}

}
