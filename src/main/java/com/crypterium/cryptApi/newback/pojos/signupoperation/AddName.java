
package com.crypterium.cryptApi.newback.pojos.signupoperation;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class AddName {

    @Expose
    private String firstName;
    @Expose
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public AddName setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AddName setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
