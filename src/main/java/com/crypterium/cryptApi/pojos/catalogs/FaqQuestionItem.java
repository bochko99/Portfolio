
package com.crypterium.cryptApi.pojos.catalogs;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FaqQuestionItem {

    @Expose
    private String answer;
    @Expose
    private String question;

    public String getAnswer() {
        return answer;
    }

    public FaqQuestionItem setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public FaqQuestionItem setQuestion(String question) {
        this.question = question;
        return this;
    }
}
