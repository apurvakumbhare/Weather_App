package com.example.WeatherApp;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller {
	public ChatClient chatClient;
	private GetWeather getWeather;
	
	public Controller(ChatClient chatClient, GetWeather getWeather) {

		this.chatClient = chatClient;
		this.getWeather = getWeather;
	}

	@GetMapping("/chat")
	
	public ResponseEntity<String> chat(@RequestParam(name = "q") String query){
		
		return ResponseEntity.ok(
				chatClient.prompt().user(query)
				.advisors(new SimpleLoggerAdvisor())
				.tools(new ToolsAndAll(),getWeather)
				.call().content());
	}
	
}
