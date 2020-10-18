
package com.mukund;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cod",
    "message",
    "cnt",
    "list",
    "city"
})
public class Forecast {

    @JsonProperty("cod")
    private String cod;
    @JsonProperty("message")
    private long message;
    @JsonProperty("cnt")
    private long cnt;
    @JsonProperty("list")
    private java.util.List<com.mukund.List> list = null;
    @JsonProperty("city")
    private City city;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cod")
    public String getCod() {
        return cod;
    }

    @JsonProperty("cod")
    public void setCod(String cod) {
        this.cod = cod;
    }

    @JsonProperty("message")
    public long getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(long message) {
        this.message = message;
    }

    @JsonProperty("cnt")
    public long getCnt() {
        return cnt;
    }

    @JsonProperty("cnt")
    public void setCnt(long cnt) {
        this.cnt = cnt;
    }

    @JsonProperty("list")
    public java.util.List<com.mukund.List> getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(java.util.List<com.mukund.List> list) {
        this.list = list;
    }

    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(City city) {
        this.city = city;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
