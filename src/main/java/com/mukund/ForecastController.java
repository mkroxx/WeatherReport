package com.mukund;

import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
@Controller
public class ForecastController {

	
	@GetMapping("forecast")
	public ModelAndView getWeatherReport(String city) {
		ModelAndView m = new ModelAndView();
			if(city==null || city.equals("")) {
				m.setViewName("redirect:home"); 
				return m;
			}
			else
				m.setViewName("forecast.html");
		Forecast forecast = getForecast(city);
		m.addObject("f", forecast);
		return m;
	}
	
	private Forecast getForecast(String state) {
		Forecast forecast = new Forecast();
		ObjectMapper mapper = new ObjectMapper();
		try {
			forecast=mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/forecast?q="+state+"&appid=4efba25667326dbbed5637ba37a04e8f"), Forecast.class);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return forecast;
	}
}
