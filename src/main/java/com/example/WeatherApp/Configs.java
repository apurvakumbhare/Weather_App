package com.example.WeatherApp;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class Configs {
	@Bean
	public ChatClient chatClient(ChatClient.Builder chatBuilder) {
		return chatBuilder.defaultAdvisors(new SimpleLoggerAdvisor()).build();
	}
	@Bean
	public RestClient restclient() {
		return RestClient.builder().baseUrl("http://api.weatherapi.com/v1" ).build();
	}
	
}
