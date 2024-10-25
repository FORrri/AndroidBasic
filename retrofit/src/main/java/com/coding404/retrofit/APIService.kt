package com.coding404.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    //https://square.github.io/retrofit/ <-공식문서 확인
    @GET("6b937efa-6994-4345-a1b5-0618468980d7") //BASE_URL + 요청주소
    //fun getData() : Call<ResponseData> //call<저장할객체>
    suspend fun getData() : Response<ResponseData> //코루틴을 사용하는 방법




}