package com.example.WeatherApp;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.i18n.LocaleContextHolder;

public class ToolsAndAll {
	public Logger logger=LoggerFactory.getLogger(getClass().getName());
	@Tool(description = "Get the Current date and Time in user's zone.")
	public String getCurrentDateAndTime() {
		logger.info("Tool Calling");
		logger.info("Get the Current date and Time in user's zone.");
		return LocalDateTime.now().atZone(
				LocaleContextHolder
				.getTimeZone()
				.toZoneId())
				.toString();
	}
	
	
}
