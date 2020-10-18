
package com.mukund;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dt",
    "main",
    "weather",
    "clouds",
    "wind",
    "visibility",
    "pop",
    "rain",
    "sys",
    "dt_txt"
})
public class List {

    @JsonProperty("dt")
    private long dt;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("weather")
    private java.util.List<Weather> weather = null;
    @JsonProperty("clouds")
    private Clouds clouds;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("visibility")
    private long visibility;
    @JsonProperty("pop")
    private double pop;
    @JsonProperty("rain")
    private Rain rain;
    @JsonProperty("sys")
    private Sys sys;
    @JsonProperty("dt_txt")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dtTxt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    public List() {
		// TODO Auto-generated constructor stub
	}

    @JsonProperty("dt")
    public long getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(long dt) {
        this.dt = dt;
    }

    @JsonProperty("main")
    public Main getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(Main main) {
        this.main = main;
    }

    @JsonProperty("weather")
    public java.util.List<Weather> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    @JsonProperty("clouds")
    public Clouds getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("wind")
    public Wind getWind() {
        return wind;
    }

    @JsonProperty("wind")
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @JsonProperty("visibility")
    public long getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(long visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("pop")
    public double getPop() {
        return pop;
    }

    @JsonProperty("pop")
    public void setPop(double pop) {
        this.pop = pop;
    }

    @JsonProperty("rain")
    public Rain getRain() {
        return rain;
    }

    @JsonProperty("rain")
    public void setRain(Rain rain) {
        this.rain = rain;
    }

    @JsonProperty("sys")
    public Sys getSys() {
        return sys;
    }

    @JsonProperty("sys")
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    @JsonProperty("dt_txt")
    public Date getDtTxt() {
        return dtTxt;
    }

    @JsonProperty("dt_txt")
    public void setDtTxt(Date dtTxt) {
        this.dtTxt = dtTxt;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
    public Date tomarrow() {
    	ZoneId defaultZoneId = ZoneId.systemDefault();
    	//Converting the date to Instant
    	Instant instant = dtTxt.toInstant();
    	//Converting the Date to LocalDate
    	LocalDateTime localDate = instant.atZone(defaultZoneId).toLocalDateTime();
    	localDate=localDate.plusDays(1);
    	return Date.from(localDate.atZone(defaultZoneId).toInstant());
    }
    
    public Date dayAfterTomarrow() {
    	ZoneId defaultZoneId = ZoneId.systemDefault();
    	//Converting the date to Instant
    	Instant instant = dtTxt.toInstant();
    	//Converting the Date to LocalDate
    	LocalDateTime localDate = instant.atZone(defaultZoneId).toLocalDateTime();
    	localDate=localDate.plusDays(2);
    	return Date.from(localDate.atZone(defaultZoneId).toInstant());
    }
    
    public Date nextDayAfterTomarrow() {
    	ZoneId defaultZoneId = ZoneId.systemDefault();
    	//Converting the date to Instant
    	Instant instant = dtTxt.toInstant();
    	//Converting the Date to LocalDate
    	LocalDateTime localDate = instant.atZone(defaultZoneId).toLocalDateTime();
    	localDate=localDate.plusDays(3);
    	return Date.from(localDate.atZone(defaultZoneId).toInstant());
    }

}
