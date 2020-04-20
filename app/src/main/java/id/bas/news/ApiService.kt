package id.bas.news

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("exec")
    fun getNews (@Query("id") id : String,
                 @Query("sheet") sheet : String
                 ) : Call<ResponseNews>

}