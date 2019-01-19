import java.util.ArrayList;
/**
 * POJO for the movie data retrieved from TMDB
 * @author Marcus Billgren
 *
 */
public class Movie {
	
	private int id;
	private String title;
	private long popularity;
	private String release_date;
	private ArrayList<String> genre;
	
	public Movie() {
		genre = new ArrayList<>();
	}
	
	public ArrayList<String> getGenre() {
		return genre;
	}
	public void setGenre(ArrayList<String> genre) {
		this.genre = genre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getPopularity() {
		return popularity;
	}
	public void setPopularity(long popularity) {
		this.popularity = popularity;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	
	private String getAllGenres() {
		
		StringBuilder sb = new StringBuilder();
		genre.forEach(g -> sb.append(g.toString() +", "));
		sb.deleteCharAt( sb.length() -2 );
		return sb.toString().trim();
	}
	
	@Override
	public String toString() {
		
		return  "title: " + title+ "\n" +
				"genre(s): " + getAllGenres() + "\n" +
				"database id: " + id+ "\n" +
				"popularity: " + popularity +"\n" +
				"release date: " + release_date +"\n";
	}
	

}
