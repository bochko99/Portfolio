
package com.crypterium.cryptApi.oldback.pojos.operations;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class OperationsCommentModel {

    @Expose
    private String comment;

    public String getComment() {
        return comment;
    }

    public OperationsCommentModel setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
