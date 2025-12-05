package com.example.WeatherApp;

import java.util.Map;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

public class GetWeather {

	public RestClient restclient;
	
	public GetWeather(RestClient restclient) {
		
		this.restclient = restclient;
	}

	@Value("${app.weather.api.key}")
	private String weatherAPIKey ;
	
	@Tool(description = "Get Weather information of given city. ")
	public String getWeatherDetails(@ToolParam(description = "give the name of city Whose weather is to be known")String city) {
		var response=restclient.
				get()
				.uri(builder->builder.path("/current.json")
				.queryParam("q",city)
				.queryParam("key",weatherAPIKey)
				.build())
				
				.retrieve()
				.body(new ParameterizedTypeReference<Map<String,Object>>() {
				});
		
		return response.toString();
	}
}
