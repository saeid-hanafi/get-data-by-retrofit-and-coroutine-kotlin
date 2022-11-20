package ir.fbscodes.kotlintest

import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("api/users/")
    suspend fun getStudents(@Query("page") page: Int): JsonObject
}