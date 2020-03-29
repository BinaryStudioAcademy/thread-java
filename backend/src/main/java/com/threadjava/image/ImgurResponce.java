package com.threadjava.image;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImgurResponce {

    @JsonProperty("data")
    @Getter @Setter public Data data;
    @JsonProperty("success")
    @Getter @Setter public Boolean success;
    @JsonProperty("status")
    @Getter @Setter public Integer status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class Data {

        @JsonProperty("id")
        @Getter @Setter public String id;
        @JsonProperty("title")
        @Getter @Setter public Object title;
        @JsonProperty("description")
        @Getter @Setter public Object description;
        @JsonProperty("datetime")
        @Getter @Setter public Integer datetime;
        @JsonProperty("type")
        @Getter @Setter public String type;
        @JsonProperty("animated")
        @Getter @Setter public Boolean animated;
        @JsonProperty("width")
        @Getter @Setter public Integer width;
        @JsonProperty("height")
        @Getter @Setter public Integer height;
        @JsonProperty("size")
        @Getter @Setter public Integer size;
        @JsonProperty("views")
        @Getter @Setter public Integer views;
        @JsonProperty("bandwidth")
        @Getter @Setter public Integer bandwidth;
        @JsonProperty("vote")
        @Getter @Setter public Object vote;
        @JsonProperty("favorite")
        @Getter @Setter public Boolean favorite;
        @JsonProperty("nsfw")
        @Getter @Setter public Object nsfw;
        @JsonProperty("section")
        @Getter @Setter public Object section;
        @JsonProperty("account_url")
        @Getter @Setter public Object accountUrl;
        @JsonProperty("account_id")
        @Getter @Setter public Integer accountId;
        @JsonProperty("is_ad")
        @Getter @Setter public Boolean isAd;
        @JsonProperty("in_most_viral")
        @Getter @Setter public Boolean inMostViral;
        @JsonProperty("has_sound")
        @Getter @Setter public Boolean hasSound;
        @JsonProperty("tags")
        @Getter @Setter public List<Object> tags = null;
        @JsonProperty("ad_type")
        @Getter @Setter public Integer adType;
        @JsonProperty("ad_url")
        @Getter @Setter public String adUrl;
        @JsonProperty("edited")
        @Getter @Setter public String edited;
        @JsonProperty("in_gallery")
        @Getter @Setter public Boolean inGallery;
        @JsonProperty("deletehash")
        @Getter @Setter public String deletehash;
        @JsonProperty("name")
        @Getter @Setter public String name;
        @JsonProperty("link")
        @Getter @Setter public String link;
    }
}