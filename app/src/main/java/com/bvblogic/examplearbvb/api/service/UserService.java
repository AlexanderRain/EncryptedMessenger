package com.bvblogic.examplearbvb.api.service;

import com.bvblogic.examplearbvb.api.model.User;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @GET("/users")
    Observable<List<User>> getAllUsers(@Header("Authorization") String token);

    @GET("/users/{username}")
    Observable<User> getUserByUsername(@Header("Authorization") String token, @Path("username") String username);

    @POST("/users")
    Observable<ResponseBody> register(@Body User user);

    @PATCH("/users/{username}")
    Observable<User> updateUser(@Header("Authorization") String token, @Path("username") String username, @Body User user);

    @DELETE("/users/{username}")
    Observable<User> deleteUser(@Header("Authorization") String token, @Path("username") String username);

    @POST("/auth")
    Observable<List<User>> login(@Header("Authorization") String token);

}
