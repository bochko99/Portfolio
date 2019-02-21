
package com.crypterium.cryptApi.pojos.hotels;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class HotelsSearchModel {

    @Expose
    private List<HotelsSuggestionModel> hotelsSuggestionModels;
    @Expose
    private String term;
    @Expose
    private Long totalSuggestions;

    public List<HotelsSuggestionModel> getHotelsSuggestionModels() {
        return hotelsSuggestionModels;
    }

    public HotelsSearchModel setHotelsSuggestionModels(List<HotelsSuggestionModel> hotelsSuggestionModels) {
        this.hotelsSuggestionModels = hotelsSuggestionModels;
        return this;
    }

    public String getTerm() {
        return term;
    }

    public HotelsSearchModel setTerm(String term) {
        this.term = term;
        return this;
    }

    public Long getTotalSuggestions() {
        return totalSuggestions;
    }

    public HotelsSearchModel setTotalSuggestions(Long totalSuggestions) {
        this.totalSuggestions = totalSuggestions;
        return this;
    }
}
