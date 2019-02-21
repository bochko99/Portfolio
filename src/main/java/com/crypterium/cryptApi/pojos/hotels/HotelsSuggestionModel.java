
package com.crypterium.cryptApi.pojos.hotels;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class HotelsSuggestionModel {

    @Expose
    private String caption;
    @Expose
    private String group;
    @Expose
    private Long highlightedIndex;
    @Expose
    private Long highlightedLength;
    @Expose
    private String id;
    @Expose
    private String landmarkCityId;
    @Expose
    private Long latitude;
    @Expose
    private Long longitude;
    @Expose
    private String name;
    @Expose
    private String type;

    public String getCaption() {
        return caption;
    }

    public HotelsSuggestionModel setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public HotelsSuggestionModel setGroup(String group) {
        this.group = group;
        return this;
    }

    public Long getHighlightedIndex() {
        return highlightedIndex;
    }

    public HotelsSuggestionModel setHighlightedIndex(Long highlightedIndex) {
        this.highlightedIndex = highlightedIndex;
        return this;
    }

    public Long getHighlightedLength() {
        return highlightedLength;
    }

    public HotelsSuggestionModel setHighlightedLength(Long highlightedLength) {
        this.highlightedLength = highlightedLength;
        return this;
    }

    public String getId() {
        return id;
    }

    public HotelsSuggestionModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getLandmarkCityId() {
        return landmarkCityId;
    }

    public HotelsSuggestionModel setLandmarkCityId(String landmarkCityId) {
        this.landmarkCityId = landmarkCityId;
        return this;
    }

    public Long getLatitude() {
        return latitude;
    }

    public HotelsSuggestionModel setLatitude(Long latitude) {
        this.latitude = latitude;
        return this;
    }

    public Long getLongitude() {
        return longitude;
    }

    public HotelsSuggestionModel setLongitude(Long longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getName() {
        return name;
    }

    public HotelsSuggestionModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public HotelsSuggestionModel setType(String type) {
        this.type = type;
        return this;
    }
}
