package ir.fbscodes.kotlintest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServicesDB {
    private val apiServices by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiServices::class.java)
    }

    @JvmName("getApiServices1")
    internal fun getApiServices(): ApiServices {
        return apiServices
    }
}