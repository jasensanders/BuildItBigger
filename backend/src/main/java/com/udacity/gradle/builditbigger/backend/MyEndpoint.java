/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.udacity.gradle.builditbigger.backend;

import com.example.jokes.JokeBuilder;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.builditbigger.gradle.udacity.com",
    ownerName = "backend.builditbigger.gradle.udacity.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that returns a Joke from the JokeBuilder library */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {

        //Setup a serializable class for transport of response. aka. the Bean.
        MyBean response = new MyBean();

        //Call Library to generate joke.
        JokeBuilder jokeSource = new JokeBuilder();
        String joke = jokeSource.randomJoke();

        //Set the data for the api response
        response.setData("Hi "+ name +", " + joke);

        return response;
    }

}
