package com.quintonsnewyorktimes.connection;

import com.quintonsnewyorktimes.models.Response;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by punit.shrirao on 09-05-2017.
 */

public interface NetworkService {


    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=mybn7amIf2gTtqANTYpjsaGtUlQeI5kJ")
    Observable<Response> getBaseURL();
}
