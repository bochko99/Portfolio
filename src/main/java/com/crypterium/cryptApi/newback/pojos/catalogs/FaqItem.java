
package com.crypterium.cryptApi.newback.pojos.catalogs;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FaqItem {

    @JsonProperty("code")
    private FaqItemCode code;
    @JsonProperty("items")
    private List<FaqQuestionItem> faqQuestionItems;
    @JsonProperty("title")
    private String title;

    public FaqItemCode getCode() {
        return code;
    }

    public FaqItem setCode(FaqItemCode code) {
        this.code = code;
        return this;
    }

    public List<FaqQuestionItem> getFaqQuestionItems() {
        return faqQuestionItems;
    }

    public FaqItem setFaqQuestionItems(List<FaqQuestionItem> faqQuestionItems) {
        this.faqQuestionItems = faqQuestionItems;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public FaqItem setTitle(String title) {
        this.title = title;
        return this;
    }
}
