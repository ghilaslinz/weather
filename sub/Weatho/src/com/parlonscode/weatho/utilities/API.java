package com.parlonscode.weatho.utilities;

public class API {
private static final String FORECAST_API_BASE_URL = "https://api.darksky.net/forecast/";
private static final String FORECAST_API_KEY = "71d091bfc7d4e3c2a903ca3ea9a5e54a";

public static String getForecastUrl(double latitude, double longitude) {
	return FORECAST_API_BASE_URL + FORECAST_API_KEY + "/" + latitude + "," + longitude ;
}
}
