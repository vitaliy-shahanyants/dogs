package ca.vitos.dogs.model

import io.reactivex.Single
import retrofit2.http.GET

interface DogsApi {

    @GET(value = "/DevTides/DogsApi/master/dogs.json")
    fun getDogs():Single< List<DoogBreed> >

}