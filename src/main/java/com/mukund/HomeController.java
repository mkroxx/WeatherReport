package com.mukund;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {

	Forecast forecast=null;
	
	@RequestMapping({"/","home"})
	public ModelAndView getHomepage(String main) throws FileNotFoundException {
		ModelAndView mv = new ModelAndView();
		mv.addObject("locations", getLocation());
		mv.setViewName("home.html");
		return mv;
	}
	
	@PostMapping(path = {"search"})
	public ModelAndView getWeatherReport(String city) {
		ModelAndView m = new ModelAndView("redirect:forecast");
		m.addObject("city", city);
		return m;
	}

	//api url= http://api.openweathermap.org/data/2.5/weather?q=Haryana&appid=4efba25667326dbbed5637ba37a04e8f
	//icon url= http://openweathermap.org/img/w/04n.png
	//forecast url= http://api.openweathermap.org/data/2.5/forecast?q=Haryana&appid=4efba25667326dbbed5637ba37a04e8f
	
	
	
	private List<Location> getLocation() throws FileNotFoundException{
		List<Location> locations=null;
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Location>> typeReference = new TypeReference<List<Location>>(){};
		InputStream inputStream = new FileInputStream("city.list.json");
		try {
			locations = mapper.readValue(inputStream,typeReference);
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
		return locations;
	}
}
