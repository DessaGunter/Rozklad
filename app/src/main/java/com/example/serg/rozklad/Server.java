package com.example.serg.rozklad;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Server {
    @FormUrlEncoded
    @POST("api/findbygroup")
    Call<List<FindByGroupGesult>> findbygroup(@FieldMap HashMap<String, String> postDataParams);

}
