package com.udacity.gradle.builditbigger.backend;

/** The definition of the object model for the data we are sending through endpoints
 *  (the serializable data class for transport) */
public class MyBean {

    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}