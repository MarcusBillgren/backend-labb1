
import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
/**
 * Parser of the JSON data retrieved from TBDM
 * @author Marcus Billgren
 *
 */
public class MovieParser {
	
	private static final String urlBase ="https://api.themoviedb.org/3/movie/";
	private static final String apiKey ="?api_key=ce593ce8b9508e475d3da81d78674eb4&language=en-US";
	
	
	public Movie getMovie(int id) throws UnirestException {
		
		return createMovie(convertNodeToObject( getNodeFromUrl( urlBase + id + apiKey) ) );	
	}
	
	public String getMovieData(int id) throws UnirestException {
		return createMovie( convertNodeToObject( getNodeFromUrl( urlBase + id + apiKey) ) ).toString();		
	}
	
	private HttpResponse<JsonNode> getNodeFromUrl(String url) throws UnirestException {
		
		HttpResponse<JsonNode> request = Unirest.get( url ).asJson();
		return request;
	}
	
	private JSONObject convertNodeToObject(HttpResponse<JsonNode> node) {
		JSONObject obj = node.getBody().getObject();
		return obj;
	}
	
	//create Java class from data retrieved from request
	private Movie createMovie(JSONObject obj) {
		
		Movie movie = new Movie();
		movie.setId( obj.getInt( "id" ) );
		movie.setPopularity( obj.getLong( "popularity" ) );
		movie.setRelease_date( obj.getString( "release_date" ) );
		movie.setTitle( obj.getString( "title" ) );
		
		JSONArray jArr = obj.getJSONArray( "genres" );
		for(int i = 0; i < jArr.length(); i++) {
			movie.getGenre().add( ( jArr.getJSONObject(i).getString( "name" ) ) );
		}
		
		return movie;
		
	}
	


}
