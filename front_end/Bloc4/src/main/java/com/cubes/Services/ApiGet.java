package com.cubes.Services;

import com.fasterxml.jackson.annotation.*;

public class ApiGet {
	private String lat;
	private String lon;
	
	public ApiGet() {
		this.lon="";
		this.lat="";
	}
	
	public ApiGet(String longitude, String latitude) {
		lon = longitude;
		lat = latitude;
	}
	
	@JsonSetter("lon")
    public String getLongitude() {
        return lon;
    }

	@JsonSetter("lat")
    public String getLatitude() {
        return lat;
    }
}