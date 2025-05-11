package com.example.sbandroid;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SupabaseService {
    String BASE_URL = "https://bkbqalqdtokleyerroxl.supabase.co/rest/v1/";
    String BASE_API = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImJrYnFhbHFkdG9rbGV5ZXJyb3hsIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDA1NTA2NjksImV4cCI6MjA1NjEyNjY2OX0.5h3Kh3mJAV5N0_D_vf3LqVImG4XimW5HPwIy2PgoRrM";

    @Headers({
            "apikey: " + BASE_API, //API ключ Supabase
            "Authorization: Bearer " + BASE_API,
            "Content-Type: application/json"
    })
    @POST("rpc/Autorization") //Наименование хранимой процедуры, rpc/ - указывает на то что, это хранимка
    Call<List<Map<String, Object>>> autoPost(); //Наименование фактического метода исполнителя, прописываемый в классе Supabase

    @Headers({
            "apikey: " + BASE_API,
            "Authorization: Bearer " + BASE_API,
            "Content-Type: application/json"
    })
    @POST("rpc/Incidents")
    Call<List<Map<String, Object>>> getDataView();

    @Headers({
            "apikey: " + BASE_API,
            "Authorization: Bearer " + BASE_API,
            "Content-Type: application/json"
    })
    @POST("rpc/Civils")
    Call<List<Map<String, Object>>> getDataViewCivil();

    @Headers({
            "apikey: " + BASE_API,
            "Authorization: Bearer " + BASE_API,
            "Content-Type: application/json"
    })
    @POST("rpc/SearchInc")
    Call<List<Map<String, Object>>> search(@Body Map<String, Object> arg); //Описывает тело запроса

    @Headers({
            "apikey: " + BASE_API,
            "Authorization: Bearer " + BASE_API,
            "Content-Type: application/json"
    })
    @POST("rpc/SearchCivil")
    Call<List<Map<String, Object>>> searchCivil(@Body Map<String, Object> arg);

    @Headers({
            "apikey: " + BASE_API,
            "Authorization: Bearer " + BASE_API,
            "Content-Type: application/json"
    })
    @POST("rpc/DeleteInc")
    Call<List<Map<String, Object>>> deleteInc(@Body Map<String, Object> arg);

    @Headers({
            "apikey: " + BASE_API,
            "Authorization: Bearer " + BASE_API,
            "Content-Type: application/json"
    })
    @POST("rpc/UpdateInc")
    Call<List<Map<String, Object>>> updateInc(@Body Map<String, Object> arg);

    @Headers({
            "apikey: " + BASE_API,
            "Authorization: Bearer " + BASE_API,
            "Content-Type: application/json"
    })
    @POST("rpc/CreateInc")
    Call<List<Map<String, Object>>> addInc(@Body Map<String, Object> arg);
}
