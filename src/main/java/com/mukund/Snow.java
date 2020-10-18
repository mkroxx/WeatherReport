
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
    "1h",
    "3h"
})
public class Snow {

    @JsonProperty("1h")
    private long _1h;
    @JsonProperty("3h")
    private long _3h;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("1h")
    public long get1h() {
        return _1h;
    }

    @JsonProperty("1h")
    public void set1h(long _1h) {
        this._1h = _1h;
    }

    @JsonProperty("3h")
    public long get3h() {
        return _3h;
    }

    @JsonProperty("3h")
    public void set3h(long _3h) {
        this._3h = _3h;
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
