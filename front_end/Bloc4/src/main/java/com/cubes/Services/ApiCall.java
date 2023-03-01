package com.cubes.Services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import org.json.*;

public class ApiCall {
	
	private static final String APIURL = "https://nominatim.openstreetmap.org/search?q=";
	
	public static ApiGet apiCall(String Habitation) {
			HttpClient client = HttpClient.newHttpClient();  
			HttpRequest requestapi = HttpRequest.newBuilder()
					.GET()
			        .uri(URI.create(APIURL + Habitation + "&format=json"))
			        .timeout(Duration.ofMinutes(2))
			        .header("Content-Type", "application/json")
			        .build();
			   ApiGet apiget = new ApiGet();
			   String responseapi = null;
				try {
					HttpResponse<String> responseapi1 = client.send(requestapi, HttpResponse.BodyHandlers.ofString()); 
					String prepJson = responseapi1.body();
					
					//Supprimer les crochers pour que ce soit du JSON
					String json = prepJson.substring(1, prepJson.length() - 1);
					
					JSONObject obj = new JSONObject(json);
					String lat = obj.getString("lat");
					String lon = obj.getString("lon");
					ApiGet apireturn = new ApiGet(lon,lat);
					return apireturn;
				} catch (InterruptedException e) {
					return apiget;
			} catch (IOException e) {
				return apiget;
			}		        
	}
}