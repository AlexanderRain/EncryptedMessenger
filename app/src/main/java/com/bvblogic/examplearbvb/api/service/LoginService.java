package com.bvblogic.examplearbvb.api.service;

import com.bvblogic.examplearbvb.api.model.Token;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface LoginService {
    @POST("/users")
    Observable<Token> login(@Body String username, String password, String email, String phone, String role);
}
