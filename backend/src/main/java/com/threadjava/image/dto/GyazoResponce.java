package com.threadjava.image.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class GyazoResponce {

    @JsonProperty("type")
    private String type;

    @JsonProperty("thumb_url")
    private String thumb_url;

    @JsonProperty("image_id")
    private String image_id;

    @JsonProperty("permalink_url")
    private String permalink_url;

    @JsonProperty("url")
    private String url;

    @JsonProperty("created_at")
    private String created_at;
}